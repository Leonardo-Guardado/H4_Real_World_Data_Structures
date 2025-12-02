// ArrayQueueDriver.java
// Starter file for the Queue portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runQ2_CallCenterQueue).

public class ArrayQueueDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runQ1_PrintQueue();
        //runQ2_CallCenterQueue();
        //runQ3_ThemeParkRideLine();
        //runQ4_CustomerServiceTickets();
        //runQ5_TaskSchedulingQueue();
        //runQ6_CheckoutLine();
        //runQ7_MessageQueueChatApp();
        //runQ8_PrintSpoolingBurst();
        //runQ9_RoundRobinService();
    }

    // Q1 – Print Queue
    private static void runQ1_PrintQueue() {
        // TODO: Implement task Q1 here.
        System.out.println("-----PrintQueue-----");
        ArrayQueue<String> print = new ArrayQueue<>();
        print.offer("Homework 4: CFL");
        print.offer("Humanities Report");
        print.offer("Biology Research Paper");
        print.offer("Programming Cheat Sheet");
        System.out.println("Printing Queue: " + print);
        while (!print.isEmpty()) {
            System.out.println(" Printing: " + print.poll());
        }
    }

    // Q2 – Call Center Queue
    private static void runQ2_CallCenterQueue() {
        // TODO: Implement task Q2 here.
        System.out.println("-----CallCenterQueue-----");
        ArrayQueue<String> call = new ArrayQueue<>();
        call.offer("Harley Quinn");
        call.offer("Diana Prince");
        call.offer("Harry Potter");
        call.offer("Richard Grayson");
        call.offer("Luke Skywalker");
        //Print the queue entirely to show elements
        System.out.println("Calling Queue: " + call);
        //Prints each element from front to back, one by one
        while (!call.isEmpty()) {
            System.out.println(" Calling: " + call.poll());
            System.out.println("Finished Call");
        }
    }

    // Q3 – Theme Park Ride Line
    private static void runQ3_ThemeParkRideLine() {
        // TODO: Implement task Q3 here.
        System.out.println("-----ThemeParkRideLine-----");
        ArrayQueue<String> line = new ArrayQueue<>();
        line.offer("Rider 1");
        line.offer("Rider 2");
        line.offer("Rider 3");
        line.offer("Rider 4");
        line.offer("Rider 5");
        System.out.println("Riders in Line: " + line);
        while (!line.isEmpty()) {
            System.out.println("Now Boarding: " + line.poll());
        }
        //Ending message
        System.out.println("All riders have boarded, Enjoy the ride");
    }

    // Q4 – Customer Service Tickets
    private static void runQ4_CustomerServiceTickets() {
        // TODO: Implement task Q4 here.
        System.out.println("-----CustomerServiceTickets-----");
        ArrayQueue<String> tickets = new ArrayQueue<>();
        tickets.offer("B1");
        tickets.offer("G4");
        tickets.offer("G5");
        tickets.offer("B2");
        tickets.offer("A1");
        System.out.println("Tickets in Queue: " + tickets);
        while (!tickets.isEmpty()) {
            System.out.println("Now Serving: " + tickets.poll());
        }
    }

    // Q5 – Task Scheduling Queue
    private static void runQ5_TaskSchedulingQueue() {
        // TODO: Implement task Q5 here.
        System.out.println("-----TaskSchedulingQueue-----");
        ArrayQueue<String> tasks = new ArrayQueue<>();
        tasks.offer("Store value of a1 into t1");
        tasks.offer("Store value of a2 into t2");
        tasks.offer("Add t1 and t2");
        tasks.offer("Store solution into v1");
        tasks.offer("Return v1");
        System.out.println("Tasks in Queue: " + tasks);
        while (!tasks.isEmpty()) {
            System.out.println("Undergoing task: " + tasks.poll());
        }
        System.out.println("All tasks in queue completed");
    }

    // Q6 – Checkout Line at a Store
    private static void runQ6_CheckoutLine() {
        // TODO: Implement task Q6 here.
        System.out.println("-----CheckoutLine-----");
        ArrayQueue<String> checkout = new ArrayQueue<>();
        checkout.offer("Harley");
        checkout.offer("Diana");
        checkout.offer("Harry");
        checkout.offer("Peter");
        checkout.offer("Richard");
        System.out.println("Checkout Line: " + checkout);
        while (!checkout.isEmpty()) {
            System.out.println("Now serving: " + checkout.poll());
        }
    }

    // Q7 – Message Queue in a Chat App
    private static void runQ7_MessageQueueChatApp() {
        // TODO: Implement task Q7 here.
        System.out.println("-----MessageQueueChatApp-----");
        ArrayQueue<String> messageQueue = new ArrayQueue<>();
        messageQueue.offer("Hello there!");
        messageQueue.offer("How are you?");
        messageQueue.offer("Are you still going to the party?");
        System.out.println("Message Queue: " + messageQueue);
        while (!messageQueue.isEmpty()) {
            System.out.println("Sending: " + messageQueue.poll());
        }
    }

    // Q8 – Print Spooling with Burst of Jobs
    private static void runQ8_PrintSpoolingBurst() {
        // TODO: Implement task Q8 here.
        System.out.println("-----PrintSpoolingBurst-----");
        ArrayQueue<String> burst = new ArrayQueue<>();
        //Array filled with jobs for printer
        String[] orders = {"Programming Cheat Sheet", "Biology Research Paper", "Humanities Paper"};
        //Adding two jobs at the same time into queue
        burst.offer(orders[0]);
        burst.offer(orders[1]);
        System.out.println("Adding to Print Queue: " + burst);
        System.out.println("Print Queue: " + burst);
        System.out.println("Number of Jobs: "  + burst.size());
        //"Printing two jobs at once
        System.out.println("Printing: " + burst.poll() + ", " + burst.poll());
        System.out.println("Number of Jobs: " + burst.size());

    }

    // Q9 – Round-Robin Service (Single Queue Version)
    private static void runQ9_RoundRobinService() {
        // TODO: Implement task Q9 here.
        System.out.println("-----RoundRobinService-----");
        ArrayQueue<String> roundRobin = new ArrayQueue<>();
        //Max rounds
        int maxRound = 3;
        //Count for each round
        int count = 1;
        //Incrementation variable
        int i = 0;
        roundRobin.offer("Harley");
        roundRobin.offer("Diana");
        roundRobin.offer("Harry");
        roundRobin.offer("Peter");
        roundRobin.offer("Richard");
        System.out.println("RoundRobin Service: " + roundRobin);
        //Loop will leave if maxRound is reached
        while(!roundRobin.isEmpty() && i < maxRound) {
            //Instead of poll, we will move the item to the rear of the queue
            roundRobin.moveToRear();
            System.out.println("RoundRobin Service: " + roundRobin);
            //Count is incremented
            count += 1;
            //Certain number of counts will be one round
            if(count % roundRobin.size() == 0) {
                //i will only be incremented on a certain number of counts
                i++;
                if (i  == maxRound) {
                    //All rounds have been depleted
                    System.out.println("Rounds done");
                }
                else {
                    //Rounds continue
                    System.out.println("...New Round...");
                }
            }
        }
    }
}
