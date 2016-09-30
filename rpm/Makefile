PACKAGE=vowpal-wabbit-rpm
REQUIRES_PACKAGES=bzip2 dpkg pkg-config python-adns python-imaging python-pyrex python-dev libmysqlclient-dev libssl-dev libtool libxext6 libsm6 tcl8.5 python-pip python-devel zlib-devel
VERSION=1.0.0

include ../.packaging/rpm.mk

rpm-prepare::
	mkdir -p src/usr/local/bin
	cp ../vowpalwabbit/vw src/usr/local/bin/

