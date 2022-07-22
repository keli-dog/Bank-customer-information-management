package 客户信息管理;
/*
本类封装以下信息：
        CustomerList customerList = new CustomerList(10);
        创建最大包含10个客户对象的CustomerList 对象，供以下各成员方法使用。
        该类至少提供以下方法：
public void enterMainMenu()
private void addNewCustomer()
private void modifyCustomer()
private void deleteCustomer()
private void listAllCustomers()
public static void main(String[] args)
*/

import static 客户信息管理.CMUtility.*;

public class CustomerView {
    public static void main(String[] args){
        CustomerView customerView=new CustomerView();
        customerView.enterMainMenu();
    }
    CustomerList customerList = new CustomerList();
    public void enterMainMenu() {

        while (true) {
            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("                 1 添 加 客 户\n" +
                    "                 2 修 改 客 户\n" +
                    "                 3 删 除 客 户\n" +
                    "                 4 客 户 列 表\n" +
                    "                 5  退      出\n" +
                    "               请选择(1-5)：");
            char x = readMenuSelection();
            switch (x) {

                case '1':
                    /*---------------------添加客户---------------------
                        姓名：佟刚
                性别：男
                年龄：35
                电话：010-56253825
                邮箱：tongtong@atguigu.com
                ---------------------添加完成---------------------*/
                    addNewCustomer();
                    break;
                case '2':
                    /*---------------------修改客户---------------------
                请选择待修改客户编号(-1退出)：1
                姓名(佟刚)：<直接回车表示不修改>
                性别(男)：
                年龄(35)：
                电话(010-56253825)：
                邮箱(tongtong@atguigu.com)：tongg@atguigu.com
                ---------------------修改完成---------------------*/
                    modifyCustomer();
                    break;
                case '3':
                    /*---------------------删除客户---------------------
                    请选择待删除客户编号(-1退出)：1
                    确认是否删除(Y/N)：y
                        ---------------------删除完成---------------------*/
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    return;
            }
        }
    }
    private void addNewCustomer(){
        Customer customer = new Customer();
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        customer.setName(readString(10));
        System.out.print("姓别：");
        customer.setGender(readChar());
        System.out.print("年龄：");
        customer.setAge(readInt());
        System.out.print("电话：");
        customer.setPhone(readString(12));
        System.out.print("邮箱：");
        customer.setEmail(readString(20));
        boolean flag=customerList.addCustomer(customer);
        if (flag) System.out.println("---------------------添加完成---------------------");
        else System.out.println("添加失败，请检查！");
    }
    private void modifyCustomer(){
        int index=0;
        Customer customer = new Customer();
        System.out.println("---------------------修改客户---------------------");
        System.out.print("请选择待修改客户编号(-1退出)：");
        index = readInt();
        if (index==-1) {return;}
        if (index > 0 && index <= customerList.getTotal()) {
        System.out.print("姓名("+customerList.customers[index-1].getName()+")：");
        customer.setName(readString(10));
        if (customerList.customers[index-1].getName()=="\n" ) {return;}
        System.out.print("姓别("+customerList.customers[index-1].getGender()+")：");
        customer.setGender(readChar());
        System.out.print("年龄("+customerList.customers[index-1].getAge()+")：");
        customer.setAge(readInt());
        System.out.print("电话("+customerList.customers[index-1].getPhone()+")：");
        customer.setPhone(readString(12));
        System.out.print("邮箱("+customerList.customers[index-1].getEmail()+")：");
        customer.setEmail(readString(20));
        boolean flag=customerList.replaceCustomer(index-1,customer);
        if (flag) System.out.println("---------------------修改完成---------------------");
        else System.out.println("修改失败，请检查！");
        }
        else System.out.println("输入下标不合法！");
    }
    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------\n");
        System.out.print("请选择待删除客户编号(-1退出)");
        int index = readInt();
        if (index==-1) return;
        if (index > 0 && index <= customerList.getTotal()) {
            System.out.print("确认是否删除(Y/N)：");
            char c = readConfirmSelection();
            if (c == 'Y') {
               boolean flag= customerList.deleteCustomer(index-1);
               if(flag)System.out.println("---------------------删除完成---------------------\n");
               else System.out.println("删除失败，请检查！(可能是下标越界)");
            }
        }
        else System.out.println("输入下标不合法！");
    }
    private void listAllCustomers(){
        Customer[] customers=customerList.getAllCustomers();
        System.out.print("---------------------------客户列表---------------------------\n"+
                "编号     姓名     性别    年龄         电话        邮箱         \n");
        for (int i = 0; i < customerList.getTotal(); i++) {
            System.out.print(i+1+"   "+customers[i].getName()+"     "+customers[i].getGender()+"    "+
                    customers[i].getAge()+"       "+customers[i].getPhone()+"    "+customers[i].getEmail()+"\n");
        }
        System.out.println("-------------------------客户列表完成-------------------------\n");
    }
}
