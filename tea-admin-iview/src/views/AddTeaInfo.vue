<template>
    
    <Form style="width: 50%" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100">
        <!-- <FormItem label="Book number">
            <Input v-model="ruleForm.id" readonly></Input>
        </FormItem> -->
        <FormItem label="name" prop="teaName">
            <Input v-model="ruleForm.teaName"></Input>
        </FormItem>
        <FormItem label="price" prop="teaPrice">
            <Input v-model="ruleForm.teaPrice"></Input>
        </FormItem>
        <FormItem label="description" prop="teaDescription">
            <Input v-model="ruleForm.teaDescription"></Input>
        </FormItem>
        <FormItem label="stock" prop="teaStock">
            <Input v-model="ruleForm.teaStock"></Input>
        </FormItem>
        <FormItem label="icon" prop="teaIcon">
            <Input v-model="ruleForm.teaIcon"></Input>
        </FormItem>
        <FormItem label="category type" prop="categoryType">
            <Input v-model="ruleForm.categoryType"></Input>
        </FormItem>
        <FormItem label="tag" prop="teaTag">
            <Input v-model="ruleForm.teaTag"></Input>
        </FormItem>
        <FormItem>
            <Button type="primary"  @click="submitForm('ruleForm')">submit</Button>
            <Button @click="resetForm('ruleForm')" style="margin-left: 8px">reset</Button>
        </FormItem>

    </Form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    teaName: '',
                    teaPrice: '',
                    teaDescription: '',
                    teaStock: '',
                    teaIcon: '',
                    categoryType: '',
                    teaTag: ''
                },
                rules: {
                    teaName: [
                        { required: true, message: 'tea name cannot be empty', trigger: 'blur' }
                    ],
                    teaPrice: [
                        { required: true, message: 'teaPrice cannot be empty', trigger: 'blur' }
                    ],
                    teaDescription: [
                        { required: true, message: 'teaDescription cannot be empty', trigger: 'blur' }
                    ],
                    teaStock: [
                        { required: true, message: 'teaStock cannot be empty', trigger: 'blur' }
                    ],
                    teaIcon: [
                        { required: true, message: 'teaIcon cannot be empty', trigger: 'blur' }
                    ],
                    categoryType: [
                        { required: true, message: 'categoryType cannot be empty', trigger: 'blur' }
                    ],
                    teaTag: [
                        { required: true, message: 'tea tag cannot be empty', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/admin/teaInfo/save',this.ruleForm).then(function(resp){
                            if(resp.data == 'success'){
                                _this.$alert('《'+_this.ruleForm.teaName+'》Added successfully！', 'Message', {
                                    confirmButtonText: 'confirm',
                                    callback: action => {
                                        _this.$router.push('/TeaInfoManage')
                                    }
                                })
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

