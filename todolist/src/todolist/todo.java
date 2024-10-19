	package todolist;
import java.util.*;
class todolist{
	private int size;
	private int space;
	private static final int initialcapacity=8;
	private static final int newcapacity=4;
	private String arr[];
	private String finished[];
	private int capacity;
	private int quantity;
	todolist()
	{   space=0;
		size=0;
		capacity=initialcapacity;
		quantity=newcapacity;
		arr =new String[initialcapacity];
		finished=new String[newcapacity];
	}
	public void add(String task)
	{   if(size==capacity)
			{
				extend(arr,capacity);
			}
			arr[size++]=task;
	}
	private void extend(String arr[],int capacity)
	{
		capacity*=2;
		arr=java.util.Arrays.copyOf(arr, capacity);
	}
	public void display()
	{
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public void insert(int pos,String task)
	{
		if(size==capacity)
		{
			extend(arr,capacity);
		}
		for(int i=size;i>=pos;i--)
		{
			arr[i+1]=arr[i];
		}
		arr[pos]=task;
		size++;
	}
	public void delete(int pos)
	{   if(capacity > initialcapacity && capacity>size*3)
	{
		shrink();
	}
	finished[space]=arr[pos];
	space++;
	
		for(int i=pos+1;i<size;i++)
		{
			arr[i-1]=arr[i];
		}
	 size--;
	}
	private void shrink()
	{
		capacity/=capacity;
		arr=java.util.Arrays.copyOf(arr,capacity);
	}
	public void finishedtask()
	{ if(space==quantity)
	{
		extend(finished,quantity);
	}
		for(int i=0;i<space;i++)
		{
			System.out.println(finished[i]);
		}
	}
	
	
}
public class todo {
	public static void main(String args[]) {
		  todolist list=new todolist();
          int pos,choise;
            String task;
            Scanner sc=new Scanner(System.in);
            System.out.println("\n\n...........TODO LIST.........\n");
			System.out.println("1.Add at the end\n");
			System.out.println("2.Display the Tasks\n");
			System.out.println("3.Add task at your favourite place\n");
			System.out.println("4.Finished the task(Remove IT)\n");
			System.out.println("5.Display the finished Tasks\n");
			System.out.println("6.exit\n");
			System.out.println("...........************.........\n");
			
			while(true) {
			System.out.print("Enter your choise:");
			choise=sc.nextInt();
			sc.nextLine();
			switch (choise) {
			case 1:
				System.out.println("enter the task:");
				task=sc.nextLine();
				list.add(task);
				break;
			case 2:
				list.display();
				break;
			case 3:
				System.out.println("enter the position:");
				pos=sc.nextInt();
				sc.nextLine();
				System.out.println("enter the task:");
				task=sc.nextLine();
				list.insert(pos,task);
				break;
			case 4:
				System.out.println("enter the position:");
				pos=sc.nextInt();
				list.delete(pos);
				break;
			case 5:
				System.out.println("Finished tasks are:");
				list.finishedtask();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid input");	
			}	
			}
			
}
}