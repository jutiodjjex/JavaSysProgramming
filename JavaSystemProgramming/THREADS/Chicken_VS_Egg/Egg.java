package Chicken.VS.Egg;

class Egg extends Thread
{
    Egg(String name) {
        setName(name);
    }

    @Override
    public void run()
    {
        for(int i = 0; i < 3; i++)
        {
            try{
                sleep(3000);
            }catch(InterruptedException e){}

            System.out.println("Яйцо");
        }
    }
}