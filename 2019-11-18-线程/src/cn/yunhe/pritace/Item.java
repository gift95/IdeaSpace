package cn.yunhe.pritace;

public class Item implements Runnable {
    private static int num = 80;

    @Override
/*public void run() {
	while(num>0){
		synchronized (Item.class) {
			if(num>0){
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName()+ "卖东西"+(--num));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}	
		}
		
	
}
*/
    public synchronized void run() {
        sale();
    }

    public void sale() {
        while (true) {
            if (num > 0) {
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName() + "卖东西" + (--num));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}