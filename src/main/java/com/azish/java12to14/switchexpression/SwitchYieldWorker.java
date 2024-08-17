package com.azish.java12to14.switchexpression;

public class SwitchYieldWorker {
    public static String operate(String operation, String input) {
        String message = "";
        switch (operation) {
            case "upper":
                message = input.toUpperCase();
                break;
            case "lower":
                message = input.toLowerCase();
                break;
            case "trim":
                message = input.trim();
                break;
            default:
                throw new IllegalStateException();
        }
        return message;
    }

    public static String operateWithExpression(String operation, String input) {
        return switch (operation) {
            case "upper" -> input.toUpperCase();
            case "lower" -> input.toLowerCase();
            case "trim" -> input.trim();
            default -> throw new IllegalStateException();
        };
    }

    public static String operateWithExpressionAndYield(String operation, String input) {
        return switch (operation) {
            case "upper":
                yield input.toUpperCase();
            case "lower":
                yield input.toLowerCase();
            case "trim":
                yield input.trim();
            default:
                throw new IllegalStateException();
        };
    }
}
