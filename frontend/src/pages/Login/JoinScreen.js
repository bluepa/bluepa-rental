import React, { Component } from 'react';
import { StyleSheet, Text, View, Image, TextInput } from 'react-native';
import BasicButton from '../../components/BasicButton';
function JoinScreen({ navigation }) {
  return (
    <View style={styles.container}>
      <View style={styles.title}></View>
      <View style={styles.buttons}>
        <BasicButton
          buttonColor={'#444'}
          title={'Google로 계속'}
          onPress={() => alert('확인 버튼')} />
        <BasicButton
          buttonColor={'#023e73'}
          title={'Facebook으로 계속'}
          onPress={() => alert('확인 버튼')} />
          <BasicButton
          buttonColor={'#FEE500'}
          title={'Kakao로 계속'}
          onPress={() => alert('확인 버튼')} />
        <BasicButton
          buttonColor={'#444'}
          title={'Email로 계속'}
          onPress={() =>navigation.navigate('EmailJoin')} />
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
  title: {
    width: '100%',
    height: '60%',
    justifyContent: 'center',
  },
  buttons: {
    width: '100%',
    height: '40%',
    //backgroundColor: '#1ad657',
  },
});

export default JoinScreen;