#!/bin/sh

OLANG=$(locale | grep LANGUAGE | cut -d= -f2 | cut -d: -f1 | cut -d_ -f1)
OCOUN=$(locale | grep LANGUAGE | cut -d= -f2 | cut -d: -f1 | cut -d_ -f2)

LANGUAGE="-Duser.language=$OLANG"
COUNTRY="-Duser.country=$OCOUN"


java "$LANGUAGE" "$COUNTRY" -jar ./tavernerPOS.jar
