#!/bin/sh

set -e

echo "CUSTOM_JAVA_VERSION env variable value '${CUSTOM_JAVA_VERSION}'"

if [ -n "${CUSTOM_JAVA_VERSION}" ]; then
  PACKAGE_NAME="openjdk-${CUSTOM_JAVA_VERSION}_linux-x64_bin.tar.gz"
  CUSTOM_JAVA_BASE_DIR="${HOME}/custom-java"
  BUILD_NUMBER=`echo "${CUSTOM_JAVA_VERSION}" | cut -d"+" -f2`
  MAJOR_VERSION=`echo "${CUSTOM_JAVA_VERSION}" | cut -d"+" -f1`
  PACKAGE_CHECKSUM="${CUSTOM_JAVA_PACKAGE_CHECKSUM}"

  time wget --no-verbose "https://download.java.net/java/jdk${MAJOR_VERSION}/archive/${BUILD_NUMBER}/GPL/${PACKAGE_NAME}" -O "/tmp/${PACKAGE_NAME}"
  echo "$PACKAGE_CHECKSUM  /tmp/${PACKAGE_NAME}" | sha256sum -c
  mkdir "${CUSTOM_JAVA_BASE_DIR}"
  tar xzf /tmp/${PACKAGE_NAME} -C "${CUSTOM_JAVA_BASE_DIR}"
  ls "${CUSTOM_JAVA_BASE_DIR}"
  export JAVA_HOME="${CUSTOM_JAVA_BASE_DIR}/jdk-${MAJOR_VERSION}"
  export PATH=${JAVA_HOME}/bin:${PATH}
  java -Xmx32m -version
else
  echo "Skipping custom Java installation."
fi

