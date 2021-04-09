import React, { Component } from 'react';
import { StyleSheet, Text, View, Image,Button } from 'react-native';
function SendEmailScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.header} />
      <View style={styles.content}>
        <Image
          style={{ tintColor: 'white', height: '70%', width: '70%', resizeMode: 'contain' }}
          source={require('../../assets/mail.png')} />
      </View>
      <View style={styles.title}>
        <Text style={{ fontSize: 35, color: 'white' }}>이메일을 확인해주세요!</Text>
        <Text style={styles.basicFont}>{'\n'}이메일 주소의 확인을 위해{'\n'}{'Email'}(으)로{'\n'}보내드린 이메일의 버튼을 탭하시오.</Text>
      </View>
      <View style={styles.Btn}>
        <Button title='이메일 앱 열기'
        onPress={() => alert('확인 버튼')} />
      </View>
      
      <View style={styles.footer}>
        <Text style={styles.basicFont}>이미 계정이 있습니까?</Text>
        <View style={styles.Btn}>
        <Button title = '비밀번호 로그인' titleStyle={styles.basicUlFont} onPress = {()=>navigation.navigate('TypePassword')} ></Button></View>
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
    height: '15%',
  },
  Btn: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  basicFont: {
    fontSize: 15, color: 'white', textAlign: 'center', 
  },
  basicUlFont: {
    fontSize: 15, color: 'white', textAlign: 'center',textDecorationLine: 'underline',
    }
  }
);
export default SendEmailScreen;