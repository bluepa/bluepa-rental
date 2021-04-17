
import React, { useState } from 'react';
import { Text, View, Button, StyleSheet } from 'react-native';
import BoxInput from '../components/BoxInput';
import WhiteInput from '../components/WhiteInput';
import Icon from 'react-native-vector-icons/FontAwesome5';
import { colorSet } from '../GlobalStyles'
const SigninLayout = ({ navigation, placeholder, btnTitle, onPressBtn, onPressGuide, guideMessage }) => {
    return (
        <View style={styles.container}>
            
            <View style={styles.element}>
                <BoxInput placeholder={placeholder}></BoxInput>
            </View>
            <View style={styles.element}>
                <Button title={btnTitle}
                    onPress={onPressBtn}
                    color={colorSet.softGrey}></Button>
            </View>
            <View style={styles.element}>
                <Text onPress={onPressGuide}>{guideMessage}</Text>
            </View>
        </View>
    );
}
SigninLayout.defaultProps = {
    placeholder: '내 이메일',
    btnTitle: '인증메일 받기',
    onPressBtn: () => { },
    onPressGuide: () => alert('문의 페이지'),
    guideMessage: '이메일을 등록한 적이 없으세요? 문의하기',
}
const styles = StyleSheet.create({
    container: {
        backgroundColor: colorSet.background,
    },
    element: {
        padding: 10,
    },
})
export default SigninLayout;