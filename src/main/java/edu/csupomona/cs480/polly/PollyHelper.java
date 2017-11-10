package edu.csupomona.cs480.polly;

import com.amazonaws.regions.Region;
import com.amazonaws.services.polly.AmazonPollyClient;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import java.io.InputStream;

public class PollyHelper {

    private final AmazonPollyClient polly;
    private final String voiceId = "Joanna";

    public PollyHelper(Region region) {
        // create an Amazon Polly client in a specific region
        polly = new AmazonPollyClient();
        polly.setRegion(region);
    }

    public InputStream synthesize(String text, OutputFormat format) {
        SynthesizeSpeechRequest synthReq = new SynthesizeSpeechRequest().withText(text).withVoiceId(voiceId).withOutputFormat(format);

        SynthesizeSpeechResult synthRes = polly.synthesizeSpeech(synthReq);

        return synthRes.getAudioStream();
    }
}
