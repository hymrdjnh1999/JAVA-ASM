package Controls.Items;

import java.io.IOException;
import java.util.Scanner;
import Controls.WorkWithFile.file_of_item;
import Models.Items_ett;
import Shareds.CheckMethodAll;
import Shareds.CommonMethod;
import Shareds.Constants;

/**
 * addItemToList
 */
public class addItemToList {

    static Scanner sc = new Scanner(System.in);

    public static void addItem() throws IOException {
        Items_ett Item;
        String Choice;
        StringBuilder existsReport = new StringBuilder(Constants.already_exits_report);
        file_of_item.rFileItem();
        existsReport.insert(0, "ID ");
        while (true) { // Y/y : +1 mặt hàng
            CommonMethod.clrscr();
            Item = new Items_ett();
            System.out.println("========== Them moi mot mat hang ==========");
            while (true) {
                System.out.print(Constants.input_id_item);
                Item.setID(sc.nextLine());
                if (CheckMethodAll.checkID(Item.getID(), Item) == -1) { // kiểm tra id đã tồn tại
                    if (CheckMethodAll.checkSpecialCharacter(Item.getID()) == 1)
                        break;
                } else {
                    System.out.println(existsReport);
                }
            }
            existsReport.replace(0, 3, "Ten mat hang ");
            while (true) {
                System.out.print(Constants.input_name_item);
                Item.setName(sc.nextLine());
                // kiểm tra trùng tên sản phẩm
                if (CheckMethodAll.checkName(Item.getName()) == -1) {
                    if (CheckMethodAll.checkSpecialCharacter(Item.getName()) == 1) {
                        break;
                    }
                } else {
                    System.out.println(existsReport);
                }
            }

            InputItemInfo.input(Item);
            createItemList.ListItem.add(Item);

            System.out.println(Constants.addSucessReport);
            file_of_item.wFileItem();
            System.out.print(Constants.input_y_n);
            Choice = CommonMethod.yesNo();
            if (Choice.equalsIgnoreCase("N")) {

                break;
            }
        }
    }
}