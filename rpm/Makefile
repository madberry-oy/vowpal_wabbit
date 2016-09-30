PACKAGE=vowpal-wabbit-rpm
REQUIRES_PACKAGES=boost-devel
VERSION=1.0.0

include ../.packaging/rpm.mk

rpm-prepare::
	mkdir -p src/usr/local/bin
	cp ../vowpalwabbit/vw src/usr/local/bin/

