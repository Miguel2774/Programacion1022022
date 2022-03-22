import java.util.ArrayList;

class ArrayGenerator{
    public ArrayGenerator() {
        ArrayList array = new ArrayList(100);
        int numeros = (int)(Math. random()*140+0);
        int num1 = 0;
        int num2 = 1;
        int num3;
        boolean fibonacci = false;
        while(fibonacci = false){
            if(num3 = num1 + num2 && num1 == num2 && num2 == num3){
                fibonacci = true;
        }
        }
        do{
            if(array.contains(numeros) || fibonacci == true){
                array.remove(numeros);
            }else{
                array.add(numeros);
            }
        }while(array == null || array.isEmpty());
        System.out.println(array);

    }
}



