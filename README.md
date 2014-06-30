jackson-module-jettison
=======================

Module for Jackson JSON Library allowing to Serialize and Deserialize Jettison JSON Objects and Arrays

Inspired by http://www.cowtowncoder.com/blog/archives/2011/03/entry_447.html
Most code is also from Tatu Saloranta, so all credits for the idea and code go to him.

Usage
=====
Add to your project where you are currently using 
	org.codehaus.jettison.json.JSONArray 
and/or
	org.codehaus.jettison.json.JSONObject

Servers will pick it up automatically, clients will need to something like this:

	clientConfig = new DefaultClientConfig();
	clientConfig.getClasses().add(JettisonJacksonMapperProvider.class);
	clientConfig.getClasses().add(JacksonJsonProvider.class);

Compatibility
=============
* Since Version 0.0.8 the module requires jackson 2.4.
* Since Version 0.0.3 the module requires jackson 2.0.
* Jackson 1.9.x users should use 0.0.2 20725a8f696ba8966dac10bf275cc24f98091b80