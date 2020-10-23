# The simple World plugin for Spigot.

## Usage

### First. Make plugin instance
```
String worldName = "test";
MiWorldAPI miWorldAPI = new MiWorldAPI(worldName);
```


### Load world
```
miWorldAPI.load(); //Returns MiWorld.loadState
```


### Unload world
```
miWorldAPI.unload(); //Returns boolean
```


### Get the world with the name specified in the constructor argument
```
miWorldAPI.getWorld(); //Returns world
```


### Check if the world is already loaded
```
miWorldAPI.isLoaded(); //Returns boolean
```


### Get the existence of the world with the name specified in the constructor argument
```
miWorldAPI.isWorldExist(); //Returns boolean
```