package com.example.snapcam;

import static edu.cmu.pocketsphinx.SphinxUtil.syncAssets;
import static edu.cmu.pocketsphinx.sphinxbase.setLogFile;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import edu.cmu.pocketsphinx.Config;
import edu.cmu.pocketsphinx.Decoder;


public class SpeechRecognizer {
    private static final int SAMPLE_RATE = 8000;
	
	private AudioRecord recorder;
	private Decoder decoder;

    static {
        System.loadLibrary("pocketsphinx_jni");
    }	
	
	public SpeechRecognizer(Context context)
	{
		recorder = new AudioRecord(MediaRecorder.AudioSource.VOICE_RECOGNITION,
				SAMPLE_RATE,
				AudioFormat.CHANNEL_IN_MONO,
				AudioFormat.ENCODING_PCM_16BIT,
				8192);

		Config config = Decoder.defaultConfig();

		File sdCard = Environment.getExternalStorageDirectory();
		File dataDir = new File(sdCard, "data");
		File modelsDir = new File(dataDir, "models");

		config.setString("-jsgf", joinPath(modelsDir, "dialog.gram"));
		config.setString("-hmm", joinPath(modelsDir, "acoustic"));

		config.setFloat("-samprate", SAMPLE_RATE);
		config.setInt("-maxhmmpf", 10000);
		config.setBoolean("-backtrace", true);
		config.setBoolean("-bestpath", false);
		config.setBoolean("-remove_noise", false);

		decoder = new Decoder(config);
	}
	
    private static final String joinPath(File dir, String path) {
        return new File(dir, path).getPath();
    }
    
}
