# Preliminary questions

### 1) What technical/business constraints should the data storage component of the program architecture meet to fulfill the requirement described by the customer in paragraph «Statistics» ? So what kind of component(s) (listed in the lecture) will the architecture need?

The use of a Datalake appears to be an interesting solution. This last one, allows us to store data in an important quantity respecting the 200go of daily reports of our residents. We need to store this data for an indefinite time, which is easy in a data lake.
The use of a dataLake favors the processing of data by data-scientists. The data from the peacewatcher will therefore be easy to analyze.

### 2) What business constraint should the architecture meet to fulfill the requirement describe in the paragraph «Alert»
The main constraint is that the drone should always be in contact with many peacemaker, they should reach the ones that are the closest to the citizen with a bad 'peacescore', so that the situation will quickly be resolved. And if there are many trigger next to each other we must have many peacewatchers that can be reached and then can take the hand on the situation.

### 3) What mistake(s) from Peaceland can explains the failed attempt?

blabla

### 4) Peaceland has likely forgotten some technical information in the report sent by the drone. In the future this information could help Peaceland make its peacewatchers much more efficient. Which information?

They most likely have forgoten to send the date and hour, when the report is sent.  Having those informations will held the peacemaker to analyse what's the moment were there will most likely have a problem and they can send more peace watcher then.