keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=jwt, L=Kyiv, S=Kyiv, C=UA" -keypass secret -keystore jwt.jks -storepass secret
keytool -list -rfc --keystore jwt.jks | C:\OpenSSL-Win32\bin\openssl.exe x509 -inform pem -pubkey > jwt.cert
