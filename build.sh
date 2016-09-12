#
# Copyright (c) 2010-2011 Oracle and/or its affiliates. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
#   - Redistributions of source code must retain the above copyright
#     notice, this list of conditions and the following disclaimer.
#
#   - Redistributions in binary form must reproduce the above copyright
#     notice, this list of conditions and the following disclaimer in the
#     documentation and/or other materials provided with the distribution.
#
#   - Neither the name of Oracle nor the names of its
#     contributors may be used to endorse or promote products derived
#     from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
# IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
# THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
# PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
BASE_HOME=~/java/X/atashopping

case "$1" in
build)
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/busbean
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/dao
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/dao/impl
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/dbc
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/factory
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/filter
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/servlet
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/test
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/util
	mkdir -p $BASE_HOME/WebRoot/WEB-INF/classes/ata/wx/shopping/vo

	TARGET_DIR=$BASE_HOME/WebRoot/WEB-INF/classes
	cd $BASE_HOME/src
	echo $"compiling classes ..."
	javac -d $TARGET_DIR ata/wx/shopping/dbc/*.java
	javac -d $TARGET_DIR ata/wx/shopping/factory/*.java
	javac -d $TARGET_DIR ata/wx/shopping/util/*.java
	javac -d $TARGET_DIR ata/wx/shopping/vo/*.java
	javac -d $TARGET_DIR ata/wx/shopping/dao/*.java
	javac -d $TARGET_DIR ata/wx/shopping/dao/impl/*.java
	javac -d $TARGET_DIR ata/wx/shopping/filter/*.java

	javac -d $TARGET_DIR -classpath ata/wx/shopping/factory:ata/wx/shopping/util:ata/wx/shopping/vo:$CLASSPATH ata/wx/shopping/busbean/*.java
	javac -d $TARGET_DIR -classpath ata/wx/shopping/util:ata/wx/shopping/busbean:ata/wx/shopping/dao:ata/wx/shopping/factory:ata/wx/shopping/vo:$CLASSPATH ata/wx/shopping/servlet/*.java
	javac -d $TARGET_DIR -classpath ata/wx/shopping/dao:ata/wx/shopping/vo:ata/wx/shopping/factory:ata/wx/shopping/busbean:$CLASSPATH ata/wx/shopping/test/*.java

	cd $BASE_HOME/WebRoot
	
	echo $"Create war package ..."
	jar cvf $BASE_HOME/atashopping.war *.jsp admin css images img js META-INF sql ui.html WEB-INF

	cd $BASE_HOME
	cp atashopping.war /home/pi/java/WebServ/apache-tomcat-8.0.24/webapps
	;;
clean)
	rm -rf $BASE_HOME/WebRoot/WEB-INF/classes/*
	rm atashopping.war
  	;;
*)
  	echo $"Usage: $0 {build|clean}"
  	exit 1
  	;;
esac

