Kaden Goski - 200392031 - February 22 2021

**Outline
Intro to Git and Version Control  
Use Case Diagram
Version Control Design

Storage Systems - Kaden Goski

Data Structures - Kaden Goski

Repositories
Operations  
Sequence Diagram  
Branching  
Merging  
Solving Conflicts  
Additional Functionality
Code Review Plugin  
Quality Plugin  
Conclusion - All   
Git Cheatsheet appendix?  



















2.1 Storage Systems

As the name suggests, the storage system of a VCS is responsible for storing content. While most modern VCSs utilize similar storage systems, for simplicity this discussion will focus solely on Git and its approach. Git’s storage system takes a unique approach to storing data. Other VCSs store data and changes as “a list of file-based changes” (Chacon & Straub, 2014). This means that they store the original files and the changes made to them to get them to the point of the latest commit. This approach is called delta-based version control. Git on the other hand, at least before the data is stored in pack files which will be explained afterwards, looks at data it stores in more of a filesystem approach.

The filesystem approach means that each version has a snapshot of the files and “stores a reference to that snapshot” (Chacon & Straub, 2014). If a file is unchanged in a snapshot compared to previous snapshots, it will reference the previous file instead of storing the same thing again. Basically, Git presents data in snapshots that contains complete data files instead of diffs, which is what occurs in delta-based version control.

The snapshot approach Git uses is hard to quantify in words, so an example will be used. Assume that the original file is version 1 of a file and has files A, B, and C. If a version 2 were to be committed, in which files A and B are the same but C is different, Git will store a snapshot of this new version by storing the new changes; file A and B, and referencing the unchanged file. As mentioned previously, Git’s approach to data storage using snapshots isn’t always technically true. It does utilize delta compression when it packs the files that make up the snapshots and compresses them into packfiles. This is done to compress the size of the repository in storage, however what a user sees and uses will always be in the snapshot format.



2.2 Data Structures

The data structures in version control systems are what enable them to perform version control and are what make them differ from simple storage systems. Generally, the data structures efficiently store files data and metadata that links revisions to each other allowing for a history to be created. In Git, there are two distinct data structures that it utilizes; the index, or stage and the object database. The index is mutable and can be changed after creation while objects in the object database are immutable once created. This is important as it allows for the snapshot storage format of Git to work properly as it guarantees an object in a snapshot won’t change once created.

The Git index, commonly known as the staging area, “provides the staging area between the local working directory and the local repository”, meaning that it is the area where information about each file in the repository is stored (Brown & Wilson, 2012). It is not actually a directory or a folder, but simply a file that contains the data representing each object or file in the repository. It “stores the information about what will go into your next commit” which is read when a commit occurs and stored in the repository as a snapshot (Chacon & Straub, 2014).

The second data structure is the object database. Every file and data piece in the repository is built using this database. The object database has four possible object types and three attributes. The object types are as follows. The “Tree” type which can be another tree or a blob when representing a directory. The “Blob” type which represents a file stored in the repository. The “Commit” type which points to a “Tree” that is the top-level directory for the commit as well as for parent commits. The last type, the “Tag” type has “a name and points to a commit at the point in the repository history that the tag represents” (Brown & Wilson, 2012).

All of the objects in the object database are referenced by a SHA checksum which is used to differentiate if objects are identical and if corruption has occurred. The objects created using the object database are used to form DAGs or directed acyclic graphs which are used to represent the data and its histories. The use of a DAG data structure allows for each node to have multiple parents which is needed to represent merged commits. An example of a DAG in Git can be seen in Figure 2.1.

Figure 2.1 - Git DAG Example (Brown & Wilson, 2012)
