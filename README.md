# ChocAn Final Project
## Attributers
* Eric Anderson
* Mazin Ashaq
* Arafat Iqbao
* Tommy Nguyen
* Andy Truong
* Cesar Ochoa

## Purpose
The purpose of this project is to create the data processing software
for "ChocAn" (Chocoholics Anonymous). This includes implementing required
functionalities (described in the requirements doc) for transactions between
ChocAn's local repository and Provider Terminal.

## Getting Started
When logging in, use the prepopulated ''' providerinfo.csv ''' with the list
of provider id's to input. There you will be greeted and directed to the 
provider terminal with all the menu functions listed. After you see the menu
you can utilize all the different methods. This menu screen will be available
for the lifetime of the program until you chose to quit out.

## Database
For the simplicity of writing and reading, we decided to not use a server
and instead write and read files with all external information to local
csv files. These files will change dynamically throughout the lifetime of
the program and are csv formatted (tabular).

## Additional Information
The primary hierarchy in the program is the relationship with "account" classes.
The account base class has two child classes: "Provider" and "Member". We 
decided to have these objects available to be instanciated to make populating and filling
in certain method signature easier and more efficient. Many of the other classes
are controller types to communicate between the view layer and controller layer 
in the ChocAn data processing software's program archetecture.

## Donations
Feel free to send us free bitcoin: 33VgqAQqmNu4eV5GXbCE4jcNGnWaWpKw2X
