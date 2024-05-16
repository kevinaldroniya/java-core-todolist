import java.util.Scanner;

public class ApplicationTodolist {
    public static String[] model = new String[4];

    public static Scanner scanner= new Scanner(System.in);

    public static void main(String args[]){
        viewShowTodolist();
    }

    //Business Logic

    /*
        Menampilkan Todolist
     */
    public static void showTodolist(){
        System.out.println("---Todolist---");
        for (int i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i+1;

            if (todo!=null){
                System.out.println(no+". "+todo);
            }
        }

    }

    /*
        Test Menampilkan Todolist
     */
    public static void testMenampilkanTodolist(){
        model[0]="Belajar Linux";
        model[1]="Belajar Java Dasar";
        showTodolist();
    }


    /*
        Menambah Todolist
     */
    public static void addTodolist(String todo){
        // check, is model full?
        var isFull = true;

        for (int i = 0; i < model.length; i++) {
            if (model[i]==null){
                isFull=false;
                break;
            }
        }

        if (isFull){
            var temp = model;
            model = new String[model.length*2];
            for (int i = 0; i < temp.length; i++) {
                model[i]=temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i]==null){
                model[i]=todo;
                break;
            }
        }
    }

    /*
        Test Menambahkan Todolist
     */
    public static void testAddTodolist(){
//        addTodolist("Belajar Linux");
//        addTodolist("Belajar Java");
//        addTodolist("Belajar Kafka");
        for (int i = 0; i < 20; i++) {
            addTodolist("Todo "+i);
        }
        showTodolist();
    }



    /*
        Menghapus Todolist
     */
    public static boolean removeTodolist(Integer number){
        if (number-1>= model.length){
            return false;
        }else if (model[number-1]==null){
            return false;
        }else {
            for (int i = number-1; i < model.length; i++) {
                if (i==model.length-1){
                    model[i]=null;
                }else {
                    model[i]=model[i+1];
                }
            }
            return true;
        }
    }

    /*
        Test Menghapus Todolist
     */
    public static void testRemoveTodolist(){
        addTodolist("Belajar Linux");
        addTodolist("Belajar Java");
        addTodolist("Belajar Kafka");
        addTodolist("Belajar Redis");
        showTodolist();

        removeTodolist(4);
        showTodolist();
    }


    public static String input(String info){
        System.out.print(info+" : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void viewShowTodolist(){
        while (true){
            showTodolist();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("X. Keluar");

            var input = input("Pilih");

            if (input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")){
                viewRemoveTodolist();
            }else if (input.equalsIgnoreCase("X")){
                break;
            }else {
                System.out.println("Pilihan Tidak Dimengerti");
            }
        }
    }

    private static void viewRemoveTodolist() {
        System.out.println("Menghapus Todolist");
        var number = input("Number (X jika batal)");


        if (number.equalsIgnoreCase("X")){

        }else {
            boolean success = removeTodolist(Integer.valueOf(number));
            if (!success){
                System.out.println("Error");
            }
        }
    }

    private static void viewAddTodoList() {
        System.out.println("Menambah Todolist");
        var todo = input("Todo (X jika batal)");
        if (todo.equalsIgnoreCase("X")){
            //batal
        }else {
            addTodolist(todo);
        }
    }
}
