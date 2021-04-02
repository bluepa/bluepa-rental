import React from 'react';
import {StyleSheet, Text, View, Image, TextInput} from 'react-native';
import CustomButton from '../../components/BasicButton';

function LoginScreen({ navigation }) {
  
  return (
    <BasicWrapper>
      <View style={styles.header} />
      <View style={styles.title}>
        <Text style={{fontSize:35,paddingBottom:20}}>로그인</Text>
        <View style={{width:"100%",borderBottomWidth:0.5,borderColor:'#444'}} />
      </View>
      <View style={styles.content}>
        <View style={{flexDirection:'row',justifyContent:'space-between',alignItems:'center',paddingBottom:10}}>
          <Text style={{fontSize:15}}>아이디</Text>
          <TextInput style={{borderColor: '#aaa', width:'70%', height:35, borderWidth: 1, borderRadius: 5, padding:5}}/>
        </View>
        <View style={{flexDirection:'row',justifyContent:'space-between',alignItems:'center',paddingBottom:10}}>
          <Text style={{fontSize:15}}>비밀번호</Text>
          <TextInput style={{borderColor: '#aaa', width:'70%', height:35, borderWidth: 1, borderRadius: 5, padding:5}}/>
        </View>
      </View>
      <View style={styles.footer}>
        <BasicButton
          buttonColor={'#444'}
          title={'취소'}
          onPress={() => alert('취소 버튼')}/>
        <BasicButton
        buttonColor={'#023e73'}
        title={'확인'}
        onPress={() => alert('확인 버튼')}/>
      </View>
    </BasicWrapper>
  );
}

const styles = StyleSheet.create({
  header: {
    width:'100%',
    height:'5%',
    //backgroundColor: '#ff9a9a',
  },
  title: {
    width:'100%',
    height:'18%',
    justifyContent: 'center',
    //backgroundColor: '#9aa9ff',
  },
  content: {
    flex: 1,
    paddingLeft:10,
    paddingRight:10,
    paddingBottom:30,
    //backgroundColor: '#d6ca1a',
  },
  footer: {
    width:'100%',
    height:'20%',
    //backgroundColor: '#1ad657',
  },
});
export default LoginScreen;