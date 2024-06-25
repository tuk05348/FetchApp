## Fetch Technical Challenge

This project is a native Android App written in Kotlin that retrieves data from the given URL from Fetch. The data is retrieved using the Retrofit library to make an API call (HTTP GET)
and get the list of items. The data is in the form of a list of items with each item containing an ID (integer), a List ID (integer), and a Name (string in the format "Item " followed by
a number).

A coroutine is used to make the API request as depending on the size of the data, it could be a long task and thus need to be done asynchronously. As this is the only task of the app a
simple loading message is displayed until the data is ready to be displayed.

The retrieved data is then sorted by List ID and Name. Because these two attributes are only used, the data class we use to model the deserialized data from the request only contains those
two attributes and the ID attribute is discarded. List ID and Name are sorted by using comparators, List ID is sorted numerically, while for Name, the numerical portion is extracted and is
sorted by that as well.

After sorting, the data is then transformed into a map, where List ID is the key with the value being a List of Names of each of the items associated with said List ID. The map is then
passed to RecyclerView adapter that inflates a layout containing a text view for the List ID and another RecyclerView for the list of Names. The list of Names is passed to the second
nested RecyclerView adapter where it is then displayed in a Staggered Grid Layout in a horizontal orientation.

The result is a vertically scrolling list of List IDs with a RecyclerView of horizontally scrolling Names under each List ID, with both sorted. This is done to ensure there are two distinct
actions for users when scrolling through both lists, if both were vertical lists it could be very easy for users to be unable to scroll where they want to, e.g. accidentally scrolling to
another List ID rather than scrolling through the Name list of the previous List ID. 

Instructions are displayed to ensure users are aware of the horizontally scrolling aspect of the list of Names.
