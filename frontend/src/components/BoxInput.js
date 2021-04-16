import React, { Component,useState} from 'react';
import { StyleSheet, Text, View, TextInput } from 'react-native';


const BoxInput =({description,placeholder,onSubmitEditing}) => {
    const [visible, setVisible] = useState(false);
    const [typing, setTyping] = useState(false);
    const [text, setText] = useState('');
    return (
        <TextInput 
                    style={styles.input}
                    placeholder={placeholder}
                    onSubmitEditing = {onSubmitEditing}
                    onChangeText={text => {
                        setText(text);
                        if(!typing && text.length >0){
                            setTyping(true);
                            setVisible(!visible);
                        }
                        if (text.length <1){
                            setTyping(false);
                            setVisible(!visible);
                        }

                    }}
                    />
        
    )
}
export default BoxInput;

BoxInput.defaultProps = {
    description: '주소를 확인하기위한 이메일을 보내드리겠습니다.',
    placeholder:"내 이메일 주소",
    color:'lightgray',
    onSubmitEditing: () => null,
}

const styles= StyleSheet.create({
    input:{borderColor: '#aaa', width:'100%', height:35, borderWidth: 1, borderRadius: 5, padding:5}
})