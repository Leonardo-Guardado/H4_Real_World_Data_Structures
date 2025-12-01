// CSLinkedListDriver.java
// Starter file for the Linked List portion of the Data Structures assignment.
// DO NOT change the class name or the signature of main().
// Implement ONLY the method for your assigned task (e.g., runLL3_CourseWaitlist).

import java.util.Comparator;

public class CSLinkedListDriver {

    public static void main(String[] args) {
        // TODO: Uncomment EXACTLY ONE of the following lines,
        // then implement that method below.

        //runLL1_Playlist();
        //runLL2_TodoList();
        //runLL3_CourseWaitlist();
        //runLL4_TextEditorLines();
        //runLL5_RecentlyContacted();
        //runLL6_ShoppingListAddAfter();
        //runLL7_BusRouteStops();
        runLL8_EventScheduleSorted();
        //runLL9_BugTrackerRemoveById();
        //runLL10_PlaylistShuffleCopy();
    }

    // LL1 – Music Playlist Manager
    private static void runLL1_Playlist() {
        // TODO: Implement task LL1 here.
        // See the assignment handout for the scenario description.
        System.out.println("-----Playlist-----");
        CSLinkedList<String> playlist = new CSLinkedList<>();
        playlist.add("Dissipate-Polaris");
        playlist.add("Gimme_Shelter-Rolling_Stones");
        playlist.add("We'll_Be_OK-Asking_Alexandria");
        playlist.add("Truth-Alexander_Ebert");
        //Printing Current Playlist
        System.out.println(playlist);
        //Adding to the front of playlist
        String new_song = "Dream_On-Aerosmith";
        System.out.println("New song: " + new_song);
        playlist.add(0,new_song);
        System.out.println(playlist);
        //Removing from the middle
        String removed = playlist.get(1);
        playlist.remove(1);
        System.out.println("Removed Song: " + removed);
        System.out.println(playlist);
        System.out.println();
    }

    // LL2 – To-Do List with Priorities
    private static void runLL2_TodoList() {
        // TODO: Implement task LL2 here.
        System.out.println("-----TodoList-----");
        CSLinkedList<String> todo = new CSLinkedList<>();
        todo.add("Clean_Room");
        todo.add("Broom");
        todo.add("Mop");
        todo.add("Laundry");
        System.out.println(todo);
        //Adding Urgent Tasks
        String urgent1 = "Taking_Out_Trash";
        String urgent2 = "Clean_Bathroom";
        System.out.println("Urgent Tasks: " + urgent1 + ", " + urgent2);
        todo.add(0, urgent1);
        todo.add(0, urgent2);
        System.out.println(todo);
        //Completed Tasks
        String completed1 = todo.get(todo.indexOf("Broom"));
        String completed2 = todo.get(todo.indexOf("Mop"));
        String completed3 = todo.get(todo.indexOf("Taking_Out_Trash"));
        System.out.println("Completed Tasks: " + completed1 + ", " + completed2 + ", " + completed3);
        todo.remove(completed1);
        todo.remove(completed2);
        todo.remove(completed3);
        System.out.println(todo);
        System.out.println();
    }

    // LL3 – Course Waitlist (No Duplicates)
    private static void runLL3_CourseWaitlist() {
        // TODO: Implement task LL3 here.
        // You may add a helper method addIfAbsent(E item) to CSLinkedList if needed.
        System.out.println("-----CourseWaitlist-----");
        CSLinkedList<String> waitlist = new CSLinkedList<String>();
        waitlist.addIfAbsent("John");
        waitlist.addIfAbsent("John");
        waitlist.addIfAbsent("Leona");
        waitlist.addIfAbsent("Andrew");
        waitlist.addIfAbsent("Rebecca");
        waitlist.addIfAbsent("Andrea");
        waitlist.addIfAbsent("Leona");
        waitlist.addIfAbsent("Luis");
        waitlist.addIfAbsent("Andrew");
        System.out.println("Waitlist: " + waitlist);
        System.out.println();
    }

    // LL4 – Text Editor Line Manager
    private static void runLL4_TextEditorLines() {
        // TODO: Implement task LL4 here.
        System.out.println("-----TextEditorLines-----");
        CSLinkedList<String> lines = new CSLinkedList<>();
        lines.add("Hello there");
        lines.add("My name is Leonardo.");
        lines.add("I am a computer science major.");
        lines.add("I like playing video-games.");
        System.out.println(lines);
        //Adding enter
        String enter = "\n";
        lines.add(1, enter);
        System.out.println(lines);
        //Deleting line
        lines.remove(3);
        System.out.println(lines);
        System.out.println();
    }

    // LL5 – Recently Contacted Friends (Move to Front)
    private static void runLL5_RecentlyContacted() {
        // TODO: Implement task LL5 here.
        // You may add a helper method moveToFront(E item) to CSLinkedList if needed.
        System.out.println("-----Recently Contacted-----");
        CSLinkedList<String> contacts = new CSLinkedList<>();
        contacts.add("Leonardo");
        contacts.add("Jacob");
        contacts.add("Melissa");
        contacts.add("Joseph");
        contacts.add("Lisa");
        System.out.println("Before Contacting: " + contacts);
        //Move Recently Contacted
        contacts.moveToFront("Joseph");
        contacts.moveToFront("Melissa");
        System.out.println("After Contacting: " + contacts);
        System.out.println();


    }

    // LL6 – Shopping List: Insert After Item
    private static void runLL6_ShoppingListAddAfter() {
        // TODO: Implement task LL6 here.
        // You may add a helper method addAfter(E target, E newItem) to CSLinkedList if needed.
        System.out.println("-----ShoppingListAddAfter-----");
        CSLinkedList<String> shoppingList = new CSLinkedList<>();
        shoppingList.add("Apples");
        shoppingList.add("Milk");
        shoppingList.add("Eggs");
        shoppingList.add("Coffee");
        shoppingList.add("Bread");
        shoppingList.add("Carrots");
        System.out.println("Original: " + shoppingList);
        //Add new things to shopping list
        String new1 = "Sugar";
        String new2 = "Oranges";
        System.out.println("Added items: "+ new1 + ", " + new2);
        shoppingList.addAfter("Coffee",new1);
        shoppingList.addAfter("Apples",new2);
        System.out.println("New: " + shoppingList);
        System.out.println();
    }

    // LL7 – Bus Route Stops
    private static void runLL7_BusRouteStops() {
        // TODO: Implement task LL7 here.
        System.out.println("-----BusRouteStops-----");
        CSLinkedList<String> stops = new CSLinkedList<>();
        stops.add("Avenue P");
        stops.add("Ranch Vista");
        stops.add("15th Street E");
        stops.add("25th Street E");
        System.out.println("Original Route: " + stops);
        String newStop = "Avenue O";
        System.out.println("New Stop: " + newStop);
        stops.add(3, newStop);
        System.out.println("Removing Stop: " + stops.remove(stops.indexOf("15th Street E")));
        System.out.println("New Route: " + stops);
        System.out.println();
    }

    // LL8 – Event Schedule (Insert by Time)
    //Comparator for to compare each item going into the list
    // Negative -> Before
    // 0 -> Same
    // Positive -> After
    static Comparator<String> time = (a,b) -> (int)(a.compareTo(b));
    private static void runLL8_EventScheduleSorted() {
        // TODO: Implement task LL8 here.
        // You may add a helper method addInOrder(E item, Comparator<E> cmp) to CSLinkedList if needed.
        System.out.println("-----EventScheduleSorted-----");
        CSLinkedList<String> events = new CSLinkedList<String>();
        events.addInOrder("07:00 Wake_Up", time);
        events.addInOrder("08:00 Shower", time);
        events.addInOrder("10:00 Start First Class", time);
        events.addInOrder("09:00 Breakfast", time);
        events.addInOrder("09:30 Get ready for school", time);
        for (String event : events) {
            System.out.println(event);
        }

    }

    // LL9 – Bug Tracker List (Remove by ID)
    private static void runLL9_BugTrackerRemoveById() {
        // TODO: Implement task LL9 here.
        // You may add a helper method removeFirstOccurrence(E item) to CSLinkedList if needed.
        System.out.println("-----BugTrackerRemoveById-----");
        CSLinkedList<String> bugtracker = new CSLinkedList<>();
        bugtracker.add("Syntax Error");
        bugtracker.add("NullPointerException");
        bugtracker.add("Memory Leak");
        bugtracker.add("Stack Overflow");
        bugtracker.add("Syntax Error");
        System.out.println("Original BugTracker: " + bugtracker);
        bugtracker.removeFirstOccurrence("Syntax Error");
        System.out.println("Updated BugTracker: " + bugtracker);
        System.out.println();

    }

    // LL10 – Playlist Shuffle Copy
    private static void runLL10_PlaylistShuffleCopy() {
        // TODO: Implement task LL10 here.
        // You may add a helper method copy() to CSLinkedList if needed.
        System.out.println("-----PlaylistShuffleCopy-----");
        CSLinkedList<String> playlist = new CSLinkedList<>();
        CSLinkedList<String>shuffledPlaylist = new CSLinkedList<>();
        playlist.add("Dissipate-Polaris");
        playlist.add("Gimme_Shelter-Rolling_Stones");
        playlist.add("We'll_Be_OK-Asking_Alexandria");
        playlist.add("Truth-Alexander_Ebert");
        playlist.add("BodySnatchers-Radiohead");

        shuffledPlaylist = playlist.copy();
        System.out.println("Original Playlist: " + playlist);
        System.out.println("Updated Playlist: " + shuffledPlaylist);
        System.out.println();

    }
}
