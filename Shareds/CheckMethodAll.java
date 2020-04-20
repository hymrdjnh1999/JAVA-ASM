package Shareds;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Controls.Bills.createBillList;
import Controls.Customers.createCustomerList;
import Controls.Items.*;
import Models.Customer_ett;
import Models.Items_ett;

/**
 * CheckMethodAll
 */
public class CheckMethodAll {
    static Scanner in = new Scanner(System.in);

    public static Integer checkID(String id, Object x) {
        if (x instanceof Items_ett) {
            for (int i = 0; i < createItemList.ListItem.size(); i++) {
                if (createItemList.ListItem.get(i).getID().equals(id)) {
                    return i;
                }
            }
        } else if (x instanceof Customer_ett) {
            for (int i = 0; i < createCustomerList.listCustomer.size(); i++) {
                if (createCustomerList.listCustomer.get(i).getID().equals(id)) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < createBillList.listBill.size(); i++) {
                if (createBillList.listBill.get(i).get_Bill_ID().equals(id)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // method kiểm tra tồn tại tên của item
    public static Integer checkName(String name) {
        Integer index = -1;
        for (int i = 0; i < createItemList.ListItem.size(); i++) {

            if (createItemList.ListItem.get(i).getName().equalsIgnoreCase(name)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    // method kiểm tra tồn tại của số đt khách hàng
    public static Integer checkIsExistsPhoneNumBer(String number) {
        Integer index = -1;
        for (int i = 0; i < createCustomerList.listCustomer.size(); i++) {
            if (createCustomerList.listCustomer.get(i).getPhoneNumber().equals(number)) {
                index = i;
                return index;
            }
        }
        return index;
    }

    static Integer x;

    // kiểm tra dữ liệu nhập cho 1 số nguyên
    public static Integer checkIntegerInput() {

        boolean checkEx = false;
        while (checkEx == false) {
            try {
                checkEx = true;
                x = Integer.parseInt(in.nextLine());

            } catch (Exception e) {
                System.out.print("Sai kieu du lieu! Chi tiet : " + e.getLocalizedMessage() + "\nMoi nhap lai : ");
                checkEx = false;
            }
        }
        return x;
    }

    public static Integer checkSpecialCharacter(String x) {

        // return -1 chuỗi trống
        // return = 0 chuỗi chứa kí tự đặc biệt
        // return = 1 chuỗi chuẩn
        int check = -1;

        Pattern p = Pattern.compile("[^\\s\\w]");
        Matcher m = p.matcher(x);
        boolean b = m.find();
        if (b) {
            System.out.println(Constants.ex_character_special);
            return check;
        } else
            check += 2;
        if (x.trim().isEmpty() || x == null) {
            System.out.println(Constants.ex_empty_input);
            return 0;// chuỗi trống
        }
        return check;

    }

    public static boolean checkNumberInString(String x) {

        if (Pattern.compile("[0-9]").matcher(x).find()) {

            return true;

        }
        return false;
    }

    public static Integer checkSpecialCharacterAndNumber(String x) {

        // return -1 chuỗi trống
        // return = 0 chuỗi chứa kí tự đặc biệt
        // return = 1 chuỗi chuẩn
        int check = 1;

        Pattern p = Pattern.compile("[^\\s\\w]");
        Matcher m = p.matcher(x);
        boolean b = m.find();

        if (b) {
            System.out.println(Constants.ex_character_special);
            return -1;
        } else {
            if (!checkNumberInString(x)) {

            } else {
                check -= 1;
                System.out.println(Constants.ex_wrong_dataType + "chu cai!");
            }
        }
        if (x.trim().isEmpty() || x.equals(null)) {
            System.out.println(Constants.ex_empty_input);
            return 0;// chuỗi trống
        }
        return check;

    }

    public static boolean isPhoneNumber(String phoneNumber) {

        if (Pattern.compile("(0){1}\\d{9}").matcher(phoneNumber).find())
            return true;
        return false;
    }

    public static boolean isMail(String x) {
        if (x.contains(" "))
            return false;
        if (Pattern.compile("(\\w+@{1}\\w+.+\\w)").matcher(x).find()) {
            return true;
        }
        return false;
    }

}