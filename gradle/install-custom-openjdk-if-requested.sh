#!/bin/sh

set -e

echo "CUSTOM_JAVA_VERSION env variable value '${CUSTOM_JAVA_VERSION}'"

if [ -n "${CUSTOM_JAVA_VERSION}" ]; then
  PACKAGE_NAME="openjdk-${CUSTOM_JAVA_VERSION}_linux-x64_bin.tar.gz"
  CUSTOM_JAVA_BASE_DIR="${HOME}/custom-java"
  MAJOR_VERSION=`echo "${CUSTOM_JAVA_VERSION}" | sed "s/-ea//g" | cut -d"+" -f1`
  BUILD_NUMBER=`echo "${CUSTOM_JAVA_VERSION}" | cut -d"+" -f2`
  PACKAGE_CHECKSUM="${CUSTOM_JAVA_PACKAGE_CHECKSUM}"
  PACKAGE_URL="https://download.java.net/java/jdk${MAJOR_VERSION}/archive/${BUILD_NUMBER}/GPL/${PACKAGE_NAME}"
  if [[ "${CUSTOM_JAVA_VERSION}" =~ '-ea' ]]; then
    PACKAGE_URL=`echo "$PACKAGE_URL" | sed "s/java\/jdk/java\/early_access\/jdk/" | sed "s/archive\//\//"`
  fi

  time wget --no-verbose "${PACKAGE_URL}" -O "/tmp/${PACKAGE_NAME}"
  echo "${PACKAGE_CHECKSUM}  /tmp/${PACKAGE_NAME}" | sha256sum -c
  mkdir "${CUSTOM_JAVA_BASE_DIR}"
  tar xzf /tmp/${PACKAGE_NAME} -C "${CUSTOM_JAVA_BASE_DIR}"
  ls "${CUSTOM_JAVA_BASE_DIR}"
  export JAVA_HOME="${CUSTOM_JAVA_BASE_DIR}/jdk-${MAJOR_VERSION}"
  export PATH=${JAVA_HOME}/bin:${PATH}
  # Link to system certificates to prevent: SunCertPathBuilderException: unable to find valid certification path to requested target
  mv "${JAVA_HOME}/lib/security/cacerts" "${JAVA_HOME}/lib/security/cacerts.jdk"
  ln -s /etc/ssl/certs/java/cacerts "${JAVA_HOME}/lib/security/cacerts"
  java -Xmx32m -version
else
  echo "Skipping custom Java installation."
fi

