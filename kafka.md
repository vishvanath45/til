Keywords:

- Event
	- Any change in world state, referred in past, payment refunded, payment initiated.
- Event streaming 
	- capture data in real time
	- store for later retrival
	- manipulate, process and later react to stored messages
- Kafka
	- a pub/sub based messenging system
	- written in scala and java
	- it has following apis
	- producer API
	- consumer API
	- streams API(for doing high level transformation, like converting local time to UTC, or high level functions)
	- 

Learning from setting running kafka in CI

- Topics needs to be created first before subscribing to it (service can only run after this step)
- Pub and sub port can be same
- we can even set up local running kafka and publish and consume message in what ever way we want, in plain text, proto or whatever.
- we can reply the msg from certain offset too,
