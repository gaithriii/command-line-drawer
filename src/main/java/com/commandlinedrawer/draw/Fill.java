package com.commandlinedrawer.draw;

import com.commandlinedrawer.exception.CommandLineDrawerException;
import com.commandlinedrawer.model.CommandType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Fill extends Command {

    @Override
    public void execute(List<String> params) throws CommandLineDrawerException {
        final String regex = "-?\\d+?";
        final int paramsCount = CommandType.getParamsCount(CommandType.FILL);
        if (params.size() < paramsCount || params.size() > paramsCount) {
            throw new CommandLineDrawerException("Command F requires " + paramsCount + " params.");
        } else if (!params.get(0).matches(regex)
            || !params.get(1).matches(regex)
            || params.get(2).length() != 1
        ) {
            throw new CommandLineDrawerException("Invalid params for Command F.");
        }

        // Floodfill - fills the entire canvas with c - params.get(2)
//        fill(Integer.parseInt(params.get(0)), Integer.parseInt(params.get(1)), params.get(2).charAt(0));

        // Iterate through the existing 2d shape array and fill NULL elements only with specified character
        fill(params.get(2).charAt(0));

        printShape();
    }

    /*
    * 1. Do a recursive function to fill the canvas with specified character
    * 2. Iterate through the 2d array and fill all NULL characters with specified character
    * */

    /*  1. Fills entire canvas
    *   2. If (x, y) co-ordinates fall inside a drawn shape (inside a drawn rectangle),
    *      then it should only fill the drawn shape */
//    private void fill(int x, int y, char c) {
//        if (shape[y][x] != 0) {
//            return;
//        }
//
//        if (x > 0 || x < height || y > 0 || y < width) {
//            if (shape[y][x] == 0)
//                shape[y][x] = c;
//            fill(x + 1, y, c);
//            fill(x - 1, y, c);
//            fill(x, y - 1, c);
//            fill(x, y + 1, c);
//        }
//    }

    private void fill(char c) {
        Arrays.stream(shape).forEach(chArr -> {
            for (int i = 0; i < chArr.length; i++) {
                chArr[i] = chArr[i] == '\0' ? c : chArr[i];
            }
        });
    }
}
