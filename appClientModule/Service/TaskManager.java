package Service;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;



public class TaskManager {
	SwingWorker[] running = new SwingWorker[1];
	int runnum = running.length;
	
	
	//private ArrayList<SwingWorker> sw=new ArrayList<SwingWorker>();
	Comparator<SwingWorker> compare = new Comparator<SwingWorker>() {
		public int compare(SwingWorker s1,SwingWorker s2)
		{
			if(s1.getPriority()<s2.getPriority())
			{
				return 1;
			}
			else if(s1.getPriority()>s2.getPriority())
			{
				return -1;
			}
			else
			{
				return 0;
			}
		}
	};
	
	
	Queue<SwingWorker> sw_queue= new PriorityQueue<SwingWorker>(10,compare);
	
	public void add(SwingWorker sw){
		sw_queue.add(sw);
		regenerate();
		execute();
	}
	
	public void regenerate()
	{
		for(int i=0;i<runnum;i++)
		{
			if(running[i]==null)
			{
				break;
			}
			else
			{
				running[i].suspend(running[i].getRownum());
				sw_queue.add(running[i]);
			}
		}
	}
	
	public void execute()
	{
		for(int i=0;i<runnum;i++)
		{
			if(sw_queue.peek()==null)
			{
				break;
			}
			
			else
			{
				running[i]=sw_queue.poll();
				start(i);
			}
		}
	}


	public void delete(SwingWorker sw) {
		for(int i=0;i<runnum;i++)
		{
			if(running[i]==sw)
			{
				
				if(sw_queue.peek()!=null)
				{
					running[i]=sw_queue.poll();
					start(i);
				}
			}
		}
		
	}
	public void suspend(SwingWorker sw){
		for(int i=0;i<runnum;i++)
		{
			
			if(running[i]==sw)
			{
				
				if(sw_queue.peek()!=null)
				{
					running[i]=sw_queue.poll();
					start(i);
				}
			}
		}
	}

	public void finish(SwingWorker sw) {
		for(int i=0;i<runnum;i++)
		{
			if(running[i]==sw)
			{
				
				if(sw_queue.peek()!=null)
				{
					running[i]=sw_queue.poll();
					start(i);
				}
			}
		}
	}
	
	public void res(){
		regenerate();
		execute();
	}
	
	public void start(int i) {
		
		if(running[i].hang==true)
		{
			running[i].resume(running[i].getRownum());

		}
		else
		{
			running[i].execute();
		}
	}
	
}
