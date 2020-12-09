# BulletIt
 
FINAL SUBMISSION INFORMATION
___________________________________

The problems that this app intends to solve is the problem of organization. There are plenty of apps out there that  
work as personal planners, and android and IOS already have their own versions built in. However, there is nothing 
quite like bullet journaling. We intend to create a pen and paper like feel to a digital app. This will keep people 
far more organized and also create a fun, intuitive UI that keeps the users coming back. The approaches that we came 
up with included different organization methods and even having ONLY a to do list. We decided to take it a step further 
and implement the ability to schedule items along with having a "to do" list above all of it so that priorities for the 
day can be seen clearly and can actually get prioritized. Furthermore, we wanted to be able to cross off items that 
are finished. The reason we chose to do 2 separate lists is because priorities are priorities and they should be kept at 
the top of the list, separate from your daily scheduled tasks. This is something that is missing from scheduling apps 
on the market now, so aside from having a pen and paper like feel, this was our priority. 

BUILD INSTRUCTIONS
____________________________________

The source code is located at the github repository "https://github.com/pitouteng/BulletIt". There is a separate file 
named "Bullet_It.apk" which is provided at the head level of this directory as well. Should you choose to only take the 
.apk you may do so and not take source code. Otherwise, the source code is all available at that link along with this 
README. 

HOW TO USE
____________________________________

When launching the app, you start in the daily view. There are 3 labels at the top of the screen in this view. 
The second and third labels which contain the current date and the word "clear" respectively are both buttons. 
Inside of this daily view, you can click on where it says "Todo" on the right-hand side. This will allow you to 
type and enter an item which will appear next to the to do list button. This space represents your priorities for 
the day. If you look below this todo list. there is a blank daily planner with hours as the y axis. You can scroll 
through these hours by clicking and dragging, simulating scrolling on mobile. If you click 
anywhere on that left hand column similar to the to do list button, you will be prompted with a dialog which allows 
you to input an event item. You can choose the name of it, the duration, and the time it should be. This will add the 
event item to the scrollable view and place it at the correct time of day. 

Clicking on the middle label at the top will bring you to the monthly view. This calendar view will show the entire 
month, while highlighting the current day. In this view, you can click any particular day and it will bring you to 
that day, showing any todo items that you have stored for that day. For example, if you navigate to December 20th 
of this year and type a todo item named "shopping", and then you navigate to the monthly view and click back on 
that day, it will have saved that to do item for that day. That item will only show up for the day that you placed 
it on. Unfortunately, we were unable to make the database work with the event items for each day, so those will 
be cleared each time that you navigate to a new day. 

Clicking on the clear button when in the daily view will remove the items in the todo list and the event list views 
for that day, clearing the day of any activities. The to do list for each day will also be saved when exiting the app 
and re opening it as well. 

