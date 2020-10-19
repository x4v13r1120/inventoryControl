
public class main {
        public static void main(String[] args) {

            Inventory inventory = new Inventory();

//            //grab this neat trick from geeks for geeks
//            // check if length of args array is
//            // greater than 0
//            if (args.length > 0) {
//                System.out.println("The command line" +
//                        " arguments are:");
//
//                // iterating the args array and printing
//                // the command line arguments
//                for (String val : args) {
//                    System.out.println(val+"\n\n");
//
//                    if (val.equals("manager")) {
//
//                        System.out.println("How would you like to interact with the inventory?\n " +
//                                "1. Add an item.\n" +
//                                "2. Delete an item.\n" +
//                                "3. Update an existing item.\n" +
//                                "4. View an all existing items.\n" );
//
//                        Scanner keyboard = new Scanner(System.in);
//                        int choice = keyboard.nextInt();
//                        keyboard.close();
//
//                        if (choice == 1) {
//                            inventory.addItem();
//                        } else if (choice == 2) {
//                            inventory.deleteItem();
//                        } else if (choice == 3) {
//                            inventory.updateItem();
//                        } else if (choice == 4) {
//                            inventory.manager.selectAll();
//                        }
//
//                    } else if (val.equals("employee")) {
//                        System.out.println("Welcome here is our existing inventory.");
//                        inventory.manager.selectAll();
//
//                    }
//
//                }
//            }
//            else
//                System.out.println("No command line "+
//                        "arguments found.");
//
//
            inventory.printItems();

        }
}
