package application.rest.v1;

import application.dto.SecretDTO;
import application.services.LocationService;
import application.services.MessageService;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class Challenge {


    @PostMapping("/topsecret")
    public @ResponseBody ResponseEntity<String> topSecret(@RequestBody SecretDTO satellites) throws IOException {
        List<String> list = new ArrayList<>();
        //return a simple list of strings
        double[] pos = getLocation(satellites);
        String message = getMessage(satellites);
        list.add("{\n" +
                "     \"position\": {\n" +
                "           \"x\": "+ pos[0] +",\n" +
                "\"y\": " + pos[1] +  " },\n" +
                "     \"message\": " + message + "\n" +
                "}");
        return new ResponseEntity<>(list.toString(), HttpStatus.OK);
    }
    public double[] getLocation(SecretDTO secretDTO) throws IOException {
        double[][] positions = {{-500,-200},{100,-100},{500,100}};
        double[] distances = {secretDTO.getSatellites().get(0).getDistance(),
                secretDTO.getSatellites().get(1).getDistance(),
                secretDTO.getSatellites
                        ().get(2).getDistance()};
        return LocationService.getLocation(positions, distances);
    }

    public static String getMessage(SecretDTO secretDTO) throws IOException {
        List<List<String>> messages = new ArrayList<>();
        messages.add(Arrays.asList(secretDTO.getSatellites().get(0).getMessage()));
        messages.add(Arrays.asList(secretDTO.getSatellites().get(1).getMessage()));
        messages.add(Arrays.asList(secretDTO.getSatellites().get(2).getMessage()));
        return MessageService.completeMessage(messages);
    }




}
