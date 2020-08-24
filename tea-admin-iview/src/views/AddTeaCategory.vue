<template>
    
    <Form style="width: 50%" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="100">
        <!-- <FormItem label="Book number">
            <Input v-model="ruleForm.id" readonly></Input>
        </FormItem> -->
        <FormItem label="Category name" prop="categoryName">
            <Input v-model="ruleForm.categoryName"></Input>
        </FormItem>
        <FormItem label="Category type" prop="categoryType">
            <Input v-model="ruleForm.categoryType"></Input>
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
                    categoryName: '',
                    categoryType: ''
                },
                rules: {
                    categoryName: [
                        { required: true, message: 'Category name cannot be empty', trigger: 'blur' }
                    ],
                    categoryType:[
                        { required: true, message: 'Category type cannot be empty', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8181/admin/teaCategory/save',this.ruleForm).then(function(resp){
                            if(resp.data == 'success'){
                                _this.$alert('《'+_this.ruleForm.categoryName+'》Added successfully！', 'Message', {
                                    confirmButtonText: 'confirm',
                                    callback: action => {
                                        _this.$router.push('/TeaCategoryManage')
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

