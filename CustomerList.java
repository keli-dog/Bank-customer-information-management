package 客户信息管理;
/* 本类封装以下信息：
  Customer[] customers：用来保存客户对象的数组
  int total = 0                 ：记录已保存客户对象的数量
  该类至少提供以下构造器和方法：
  public CustomerList(int totalCustomer)
  public boolean addCustomer(Customer customer)
  public boolean replaceCustomer(int index, Customer cust)
  public boolean deleteCustomer(int index)
  public Customer[] getAllCustomers()
  public Customer getCustomer(int index)
  public int getTotal()*/
public class CustomerList {
    Customer[] customers;//用来保存客户对象的数组
    int total = 0;//记录已保存客户对象的数量
    int totalCustomer=0;//客户总数
    public CustomerList(){
        customers = new Customer[100];
        for (int i = 0; i < customers.length; i++) customers[i] = new Customer();
    }
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
        for (int i = 0; i < customers.length; i++) customers[i] = new Customer();
        this.totalCustomer=totalCustomer;
    }
    public boolean addCustomer(Customer customer){
        if (customer == null) {
            System.out.println("客户已满，无法添加！");
            return false;
        }
        customers[total++] = customer;
        return true;

    }
    public boolean replaceCustomer(int index, Customer customer){
        if (customer == null) {
            return false;
        }
        customers[index]=customer;
        return true;
    }
    public boolean deleteCustomer(int index){
        for (int i = index; i < total-1; i++) {
            customers[i]=customers[i+1];
        }
            total--;
            return true;
    }
    public Customer[] getAllCustomers(){
           return customers;
    }
    public Customer getCustomer(int index){
            return customers[index];
    }
    public int getTotal(){
        return total;
    }
}
