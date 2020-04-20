package Controls.Customers;

import java.io.IOException;
import java.util.Scanner;

import Controls.WorkWithFile.file_of_customer;
import Models.Customer_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * editCusInList
 */
public class editCusInList {

    static Scanner in = new Scanner(System.in);

    public static void editInfo() throws IOException {
        while (true) {
            StringBuilder wrongDataType = new StringBuilder(Constants.ex_wrong_dataType);
            StringBuilder notFind = new StringBuilder(Constants.ex_not_find);
            String IDCustomer, NameCustomer;
            String NumberCustomer;

            Integer index = -1;
            CommonMethod.clrscr();
            showInfoCusList.Display();
            if (createCustomerList.listCustomer.isEmpty()) {
                System.out.print("\n" + Constants.input_randomKey);
                in.nextLine();
                break;
            }
            System.out.println("======= Cap nhat thong tin khach hang =======\n");
            while (true) {// tìm id khách hàng
                System.out.print("Nhap ma khach hang: ");
                IDCustomer = in.nextLine();
                if (CheckMethodAll.checkID(IDCustomer, new Customer_ett()) != -1) {
                    index = CheckMethodAll.checkID(IDCustomer, new Customer_ett());
                    break;
                } else {
                    System.out.println(notFind.append("ID nay!"));
                }
            }
            while (true) {// kiểm tra nhập có đúng hay không.
                System.out.print("Sua ten khach hang (A-Za-z): ");
                NameCustomer = in.nextLine();
                if (CheckMethodAll.checkSpecialCharacterAndNumber(NameCustomer).equals(1))
                    break;

            }
            while (true) {
                System.out.print("Sua so dien thoai(bat dau phai la 0 va du 10 chu so) : ");
                NumberCustomer = in.nextLine();
                Integer indexPhone = CheckMethodAll.checkIsExistsPhoneNumBer(NumberCustomer);
                if (indexPhone == -1 || indexPhone == index) {
                    if (CheckMethodAll.checkSpecialCharacter(NumberCustomer).equals(1))
                        if (CheckMethodAll.isPhoneNumber(NumberCustomer) && NumberCustomer.length() == 10)
                            break;
                        else {
                            System.out.println("Chi chap nhan so hop le!");
                        }
                } else {
                    System.out.println("SDT ".concat(Constants.already_exits_report));
                }

            }
            System.out.print(Constants.updateRequest);
            if (CommonMethod.yesNo().equalsIgnoreCase("Y")) {
                createCustomerList.listCustomer.get(index).setName(NameCustomer);
                createCustomerList.listCustomer.get(index).setPhoneNumber(NumberCustomer);
                System.out.println(Constants.UpdateSucessReport);
                file_of_customer.wFileCustomer();
            } else
                System.out.println(Constants.UpdateFailReport);
            System.out.print(Constants.continueRequest);
            if (CommonMethod.yesNo().equalsIgnoreCase("N")) {
                break;
            }
        }

    }

}