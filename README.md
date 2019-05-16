# MARS EXPLORER

## Description:
You work with remote controlled Mars exploration drone, its tasks to find water, organics or any strange and unexpected things on surface of Mars.
You can control movement direction and what things around drone must be scanned for chemical composition, physical properties or any anomalies.

## Target technologies:
JSP, Servlet API, Spring MVC or any analogues (results over tools)

## Goal:
Learn target technologies on simple joke-like project about hypothetical exploration of Mars surface with remote controlled drone

## Requirements & Restrictions (givens):
- you explore limited part of surface (area of exploration) divided on equal squares (locations)
- you can use "move?direction=directionName" command to switch position to next square in one of 4 directions: west, east, north, south
- surface generates randomly, it has different relief and some squares could be inaccessible for your drone
- you automatically receive list of places of interest (something worth to be scanned) around drone while staying in location
- you can use command "scan?id=placeOfInterestId" to scan something with mentioned 'id' on surface around drone
- your goal to get N traces of water, organics or unknown technology (condition of end)
- all interactions you doing with web browser
- application must react in some adequate way on your actions and show parametrized text pages providing newest information about situation
- you free in additional features, messages, texts and any additional technologies to learn (but follow KISS and DRY)
