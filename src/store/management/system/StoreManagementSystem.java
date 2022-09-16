
package store.management.system;

import java.util.Scanner;


public class StoreManagementSystem {

   
    public static void main(String[] args) {
       
        Store my_store= new Store("Happy Store");
        
        System.out.printf("         Wlecome in %s !!!\n",my_store.getName());
        System.out.println("++++++++ Select Operation from Menu +++++++++++++");

        
 try{       
Scanner input = new Scanner(System.in);
int choice = 0;
            do {

                System.out.println("1- Products Management"); // add - remove - browser
                System.out.println("2- Users Management"); // add customer - add employee - edit salary
                System.out.println("3- Buy Product"); // ask id of customer and ask for pruduct want to buy , wrong or right
                System.out.println("4- Show Special Products"); // auto show
                System.out.println("5- Exit");

                System.out.print(">>>");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        int S1 = 0;
                        do {
                            System.out.println("++++++++++ Products Management ++++++++++ ");
                            System.out.println("1- Add Product");
                            System.out.println("2- Remove Products"); // ask for user id , if manager can remove
                            System.out.println("3- Print Products");
                            System.out.println("4- Back to main menu");
                            System.out.print(">>>");
                            S1 = input.nextInt();
                            switch (S1) {
                                case 1:
                                    System.out.print("product name: ");
                                    String pro_name = input.next();
                                    System.out.print("product price: ");
                                    double price = input.nextDouble();
                                    System.out.print("product kind: ");
                                    String special_pro = input.next();
                                    Product new_Product = new Product(pro_name, price, special_pro);
                                    my_store.addProduct(new_Product);
                                    break;
                                case 2:
                                     System.out.print("enter employee id: ");
                                     int id= input.nextInt();
                                     if(my_store.check_manager(id)){
                                    System.out.print("enter product name:");
                                    pro_name = input.next();
                                    my_store.removeProduct(pro_name);
                                     System.out.println("Removed done !!!");
                                     }else{
                                         System.out.println("employee not a manager can't remove product!!! ");
                                     }
                                    break;
                                case 3:
                                    if (my_store.products.isEmpty()) {
                                        System.out.println("store is empty !!!");
                                    } else {
                                        System.out.println("Products in store:");
                                        my_store.print_pro();
                                        
                                    }

                                    break;
                            }
                        } while (S1 != 4);
                        break;

                    case 2:
                        int S2 = 0;
                        do {
                            System.out.println("++++++++++ Users Management ++++++++++ ");
                            System.out.println("1- Add Customer");
                            System.out.println("2- Add Employee");
                            System.out.println("3- Update Employee");// increase all salarys
                            System.out.println("4- Print Users");
                            System.out.println("5- Back to main menu");
                            System.out.print(">>>");
                            S2 = input.nextInt();
                            switch (S2) {
                                case 1:
                                    System.out.print("Customer name: ");
                                    String cus_name = input.next();
                                    Customer new_Customer = new Customer(cus_name);
                                    my_store.customers.add(new_Customer);
                                    break;
                                case 2:
                                    System.out.print("Employee name: ");
                                    String emp_name = input.next();

                                    System.out.print("Employee Salary: ");
                                    double salary = input.nextDouble();
                                    System.out.print("is Employee a manager ?  (1:yes) , (2:no)? ");
                                    int x = input.nextInt();
                                    String type_emp;
                                    if (x == 1) {
                                        type_emp = "Manager";
                                    } else {
                                        type_emp = null;
                                    }
                                    Employee new_Emp = new Employee(emp_name, salary, type_emp);
                                    my_store.employees.add(new_Emp);
                                    break;
                                case 3:
                                    System.out.print("incresing salary %: ");
                                    double percent = input.nextDouble();
                                    my_store.increce_salary(percent);
                                    break;
                                case 4:
                                    if ((my_store.customers.isEmpty()) && (my_store.employees.isEmpty())) {
                                        System.out.println("no users !!!");
                                    } else {
                                        System.out.println("List of Users:");
                                        my_store.print_cust();
                                        my_store.print_emp();
                                    }
                                    break;
                            }
                        } while (S2 != 5);

                        break;
                    case 3:
                         int S3=0;
                        int n=0;
                        System.out.print("enter customer id:");
                        int cus_id = input.nextInt();
                       
                        for (int i = 0; i < my_store.customers.size(); i++) {
                            if (cus_id == my_store.customers.get(i).getID()) {
                                System.out.println(my_store.customers.get(i).toString());
                               while (S3 != -1){
                                    System.out.print("enter id of product:");
                                    int pro_id = input.nextInt();
                                    for (int j = 0; j < my_store.products.size(); j++) {
                                        if (pro_id == my_store.products.get(j).getID()) {
                                            System.out.println(my_store.products.get(j).toString());
                                            
                                            my_store.customers.get(i).addPurchased(my_store.products.get(j));
                                            n=i;
                                            break;
                                        } else  if (pro_id != my_store.products.get(j).getID()){
                                            System.out.println("product not found in store !!!!");
                                            break ;
                                        }
                                    }
                                    System.out.print("enter 0 to add another product or -1 when finish:");
                                    S3=input.nextInt();
                                } 
                            }
                        }
                          
                         System.out.printf( "%s : %s\n",my_store.customers.get(n).getTypeOfCustomer(),my_store.customers.get(n).getName()); 
                          System.out.println("bought :"); 
                         my_store.totalPrice(cus_id);
                     
                         my_store.buy(cus_id);   
                         my_store.customers.get(n).setVisits(); // 
                         my_store.customers.get(n).purchased.clear();// make purchased empty after finish every purchased
                        break;
                    case 4:
                         System.out.println("++++++++++ Special Product ++++++++++ ");
                      my_store.print_special_pro();
                        break;
                }
                System.out.println("-----------------------");
            } while (choice != 5);

        } catch (Exception e) {
            System.out.println("Invalid input !!!");
        
        }
        System.out.println("Good by !!!");
    }
}
