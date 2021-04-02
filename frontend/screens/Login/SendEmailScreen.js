import React, { Component } from 'react';
import { StyleSheet, Text, View, Image } from 'react-native';
import BasicButton from '../../components/BasicButton';
import LoginDrawer from '../../components/LoginDrawer'


function SendEmailScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.header} />
      
      <View style={styles.content}>
        <Image
          style={{ tintColor: 'white',height: '100%', width: '100%', resizeMode: 'contain' }}
          source={require('../../assets/mail.png')} />
      </View>
      <View style={styles.title}>
        <Text style={{ fontSize: 35, color: 'white' }}>이메일을 확인해주세요!</Text>
      </View>
      <View style={styles.footer}>
      </View>

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: '#333333',
  },
  header: {
    width: '100%',
    height: '5%',
  },
  title: {
    width: '100%',
    height: '30%',
    justifyContent: 'center',
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    paddingBottom: 30,
  },
  footer: {
    width: '100%',
    height: '20%',
  },
  Btn: {
    width: 150,
  }
});
export default SendEmailScreen;