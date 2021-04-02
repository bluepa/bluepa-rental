import React, { Component } from 'react';
import { StyleSheet, Text, View, Image, TextInput } from 'react-native';
import BasicButton from '../../components/BasicButton';
import WhiteInput from '../../components/WhiteInput'
import BasicTitle from '../../components/BasicTitle'
function JoinScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.header} />
      <BasicTitle text={'회원가입'}></BasicTitle>
      <View style={styles.content}>
        <WhiteInput
          description={'이메일'}>
        </WhiteInput>
        <WhiteInput 
          description={'비밀번호'}>

        </WhiteInput>
      </View>
      <View style={styles.footer}>
        <BasicButton
          buttonColor={'#444'}
          title={'취소'}
          onPress={() => alert('취소 버튼')} />
        <BasicButton
          buttonColor={'#023e73'}
          title={'확인'}
          onPress={() => alert('확인 버튼')} />
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'white',
  },
  header: {
    width: '100%',
    height: '5%',
    //backgroundColor: '#ff9a9a',
  },
  
  content: {
    flex: 1,
    paddingLeft: 10,
    paddingRight: 10,
    paddingBottom: 30,
    //backgroundColor: '#d6ca1a',
  },
  footer: {
    width: '100%',
    height: '20%',
    //backgroundColor: '#1ad657',
  },
});
export default JoinScreen;