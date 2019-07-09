#!/bin/sh
var='IPADDR='$1
sed -i -e 's/IPADDR=.*/'$var'/' pathwaytointerface
 #this one is the interface you are on. Ex(eth0)
