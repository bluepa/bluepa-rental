import React, { Component } from 'react';
import { StyleSheet, Text, View, Image, TextInput } from 'react-native';
import SimpleInput from '../../components/SimpleInput'
import {colorStyle} from '../../GlobalStyles'
import SigninLayout from '../../layouts/SigninLayout'
function TypePasswordScreen({ navigation }) {
  return (
    <View style={{...colorStyle.background,flex:1}}>
          <View>
              <SigninLayout placeholder='비밀번호를 입력하세요'
              btnTitle='로그인'
              guideMessage='비밀번호를 잊으셨습니까? 비밀번호 찾기'
              navigation={navigation}
              onPressBtn={() => {alert('Go Home')
              }}></SigninLayout>
          </View>
    </View>
  );
}
export default TypePasswordScreen;