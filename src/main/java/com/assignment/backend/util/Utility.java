package com.assignment.backend.util;

import com.assignment.backend.request.Password;

public class Utility {

        public static int generateToken() {
            int min = 100000;
            int max = 200000;
            return (int)Math.floor(Math.random() * (max - min + 1) + min);
        }

        public static String validatePassword(Password password) {

            if (password.getPassword() == null || password.getPassword() == "") {
                return "password cannot be blank";
            }

            if (password.getPassword() .length() < 8 || password.getPassword() .length() > 30) {
                return "password length cannot be less than 8 or greater 30";
            }

            if (!checkPasswordComposition(password.getPassword() )) {
                return "password must contain at least one uppercase, a lowercase, a number and a special character";
            }

            if (password.getPassword() .compareTo(password.getConfirmPassword() ) == 0) {
            } else {
                return "Password confirmation mismatch";
            }
            return "valid";
        }


    private static boolean checkPasswordComposition(String str) {
        String specialChars = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialCharsFlag = false;

        char[] chars = str.toCharArray();

        for (Character c : chars) {
            if( Character.isDigit(c)) {
                numberFlag = true;
            }
            if (specialChars.contains(c.toString())) {
                specialCharsFlag = true;
            }
            else if (Character.isUpperCase(c)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(c)) {
                lowerCaseFlag = true;
            }

            if(numberFlag && capitalFlag && lowerCaseFlag && specialCharsFlag)
                return true;
          }
        return false;
        }



}
