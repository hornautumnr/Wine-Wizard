# Wine Wizard 🍷

**Wine Wizard** is a user-friendly application that simplifies wine inventory management for vendors and provides a 
personalized experience for consumers. With features for cataloging, searching, sorting, and favoriting, this software 
enhances customer engagement and offers vendors valuable insights into customer preferences.

Who are the users of the software?
--------------------------------------------------------------------------------------------------------------------
The Wine Wizard software is designed for both wine vendors and their customers. Vendors benefit from a streamlined way 
to categorize and showcase their inventory in an appealing, organized format, while consumers can easily search, sort, 
and favorite wines, making informed purchasing decisions. The favoriting feature adds value for both users: consumers 
can track wines they enjoy, and vendors gain insights into customer preferences to help with inventory planning.

What is the purpose of the software?
---------------------------------------------------------------------------------------------------------------
Wine Wizard provides a visually appealing, user-friendly database for both wine vendors and consumers. Vendors can 
display their inventory in a structured, eye-catching way, highlighting the attributes customers find most appealing. 
Consumers benefit from a highly functional search and sorting tool that allows them to explore options, find exactly
what they want, or discover something new. Each consumer also has a personal profile where they can favorite wines to 
reference later.

Where and when will the software be used?
----------------------------------------------------------------------------------------------------------
This software can be used at a physical store (e.g., as a kiosk) or on a tablet at a restaurant for wine selection.
It can also be integrated into a vendor's website, allowing consumers to browse and make selections remotely.

How does the software work?
---------------------------------------------------------------------------------------------------------------------------
The Wine Wizard application is designed for both wine vendors (admins) and consumers, with functionality that supports 
inventory management, user accounts, data persistence, and flexible sorting options.
### Account Creation and User Roles
- **Admin Role:**
  - Admins can manage the wine inventory by adding, editing, or deleting wines through a user-friendly interface. Each
  wine entry includes details such as color, grape, region, sweetness, price, and tasting notes. Custom images can be added,
  or default options are available for each wine color.
  - Only admins can create other admin accounts, and each admin must set a unique four-digit PIN for added security. This
  ensures role-based access control within the application.
- **Consumer (User) Role:**
  - Consumers can create personal accounts to view and interact with the wine inventory. They can build a list of 
  preferred wines by favoriting options of interest, which helps them quickly access wines they like while allowing 
  vendors to track popular choices.
- **Creating an Account:** The account creation process has validation built in to ensure data integrity:
  - **Admins:** Must set a username, a secure password, and a unique four-digit PIN.
  - **Consumers:** Set up a username and password but do not require a PIN, offering a simplified setup for general users.
  - **Validation:** Usernames must be unique, passwords must meet complexity requirements (at least eight characters, 
  including uppercase and lowercase letters, numbers, and special characters), and PINs must be four-digit numbers that
  match a confirmation entry.
### Core Data Structures: WineTree, WineList, and UserHashTable
- **Wine Tree:**
  - All wines are stored in a `WineTree`, a binary search tree, for organized and efficient access. This structure
  supports searching, insertion, and deletion operations with 'O(log n)' complexity.
  - **Search Options**: Wines can be searched by name, color, grape, producer, and region.
  - **Sorting Options**: Wines are sorted by color by default, with additional comparators available for sorting by grape,
  sweetness, price, and popularity.
- **Wine List:**
  - This custom linked list stores wines extracted from the `WineTree` for sorting and display.
  - **Sorting:** `WineList` supports two versions of `mergeSort`:
    - **Default Sort** (by name) uses `Comparable`.
    - **Comparator-Based Sort** enables sorting by other attributes such as grape and price.
  - **Efficiency:** Both sorts operate in O(n log n) time, ideal for handling large wine lists.
- **User Hash Table:**
  - All user accounts are efficiently stored in a 'UserHashTable', allowing O(1) average time complexity for inserting
  and retrieving users.
  - **Collision Handling:** Uses separate chaining with linked lists for collision management.
  - **Auto-Resizing:*** Resizes dynamically to maintain performance ,with a load factor threshold ensuring minimal rehashing.
### Data Persistence
- **Loading and Saving:** Data is loaded and saved through dedicated threads, ensuring that wine and user data persist across
sessions. The `DataLoadThread` and `DataSaveThread` classes handle reading and writing serialized data files, so any updates
are retained.

Why would anyone want to use the software over existing processes?
------------------------------------------------------------------------------
Wine Wizard provides a **specialized platform** tailored for wine vendors, unlike generic inventory management software. 
This software:
- **Streamlines Inventory Management:** Organizes and categorizes wines with minimal effort from the vendor, displaying 
wines in a visually engaging format.
- **Offers Insight:** Admins gain access to data on popular wines based on user favorites, helping them plan their 
inventory to match customer preferences.
- **Enhances the Customer Experience:** Consumers can browse local inventories, discover new wines, and store preferences,
simplifying decision-making in one easy-to-access application.

## Application Walkthrough

For a complete walkthrough of the Wine Wizard application, including its features and user interface, watch this video:

[![Wine Wizard Walkthrough](https://img.youtube.com/vi/3ZyZ0Ze5LLU/0.jpg)](https://www.youtube.com/watch?v=3ZyZ0Ze5LLU&t=5s)

*Click on the image above to watch the walkthrough on YouTube.*

Technology Stack
------------------------------------------------------------------------------
- **JavaFX:** Provides a visually appealing, user-friendly graphical interface.
- **Java:** Core programming language for backend logic and data processing.
- **Custom Data Structures:**
  - `WineTree` (binary search tree) for organizing and searching wine inventory.
  - `WineList` (linked list) with custom sorting options for flexible inventory display.
  - `UserHashTable` (hash table) with collision handling and auto-resizing for efficient user management.
- **File I/O and Serialization:** Enables data persistence by saving and loading user and wine data across sessions.
- **Multithreading:** Data is saved and loaded in the background with `DataLoadThread` and `DataSaveThread`, ensuring a 
smooth user experience.