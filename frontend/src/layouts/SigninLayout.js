
import React, { useState } from 'react';
import { View, Button, StyleSheet } from 'react-native';
import BoxInput from '../components/BoxInput';
import WhiteInput from '../components/WhiteInput';

const SigninLayout = ({ navigation }) => {
    
    return(
        <View>
            <BoxInput >
              </BoxInput>
              <BoxInput>
              </BoxInput>
              <Button style={styles.Btn} title='이메일 확인'></Button>
        </View>
    );
}
const styles = StyleSheet.create({
    Btn: {
        padding: 10,
    },
})
export default SigninLayout;