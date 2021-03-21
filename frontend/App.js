// App.js
import React, {Component} from 'react';
import {StyleSheet, Text, View} from 'react-native';
import CustomButton from './CustomButton';

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
      <View style={styles.container}>
        <View style={styles.header}><Text>header</Text></View>
        <View style={styles.title}><Text style={styles.title_text}>안녕하세요{"\n"}지금 블루파-렌탈을{"\n"}시작하세요</Text></View>
        <View style={styles.content}></View>
        <View style={styles.footer}>
          <CustomButton title={"로그인"}/>
          <CustomButton title={"회원가입"}/>
        </View>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: 'white',
  },
  header: {
    width:'100%',
    height:'9%',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#ff9a9a',
  },
  title: {
    width:'100%',
    height:'18%',
    justifyContent: 'center',
    alignItems: 'flex-start',
    backgroundColor: '#9aa9ff',
  },
  title_text: {
    textAlign:"left",
  },
  content: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'white',
  },
  footer: {
    width:'100%',
    height:'20%',
    backgroundColor: 'white',
  },
});