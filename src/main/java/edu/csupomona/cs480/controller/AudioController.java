package edu.csupomona.cs480.controller;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.model.OutputFormat;
import edu.csupomona.cs480.polly.PollyHelper;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
    visit localhost:8080/audio?msg={phraseForPolly}
    ex. localhost:8080/audio?msg=ten and Polly will say ten
    additional need to find out what region your aws account is configured to for this to work
    mine was N.Virgina which is US_EAST_1 if you have an account in a different region you must either
    1) change your region to N.Virgina
    2) change PollyHelper assignment to your region IF your region supports AWS Polly
    Lastly make sure your have your root credentials in ~/.aws/credentials file (for Linux and macOS)
    not sure what the folder is for Windows
*/
@Controller
public class AudioController {

    @RequestMapping(path="/audio", produces="audio/mpeg3")
    public @ResponseBody
        //byte[] textToSpeech(@RequestParam("msg") String msg) throws IOException, JavaLayerException {
        void textToSpeech(@RequestParam("msg") String msg) throws IOException, JavaLayerException {
        PollyHelper helper = new PollyHelper(Region.getRegion(Regions.US_EAST_1));

        InputStream is = helper.synthesize(msg, OutputFormat.Mp3);

        AdvancedPlayer player = new AdvancedPlayer(is, javazoom.jl.player.FactoryRegistry.systemRegistry().createAudioDevice());

        player.setPlayBackListener(new PlaybackListener() {
            @Override
            public void playbackStarted(PlaybackEvent evt) {
                System.out.println(msg);
            }

            @Override
            public void playbackFinished(PlaybackEvent evt) {
                super.playbackFinished(evt);
            }
        });
        player.play();

        //return StreamUtils.copyToByteArray(is);
    }
}
