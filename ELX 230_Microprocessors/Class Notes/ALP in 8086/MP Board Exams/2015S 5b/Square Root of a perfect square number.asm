;author: bikalpa dhakal (@theoctober19th)
;date: 19 Oct 2017
;
;Tested OK in emu8086 assembler
;Syntax may vary slightly in other assemblers(like MASM, NASM etc)
;

.stack
.model small
.data
    number db 0e1h
    root db 1 dup(?)
    message db 'Not a perfect square!$'

.code
    main proc
        .startup
        mov al,number
        mov bl,01
        mov cl,01
        
        again:
            sub al,bl
            jz break
            jc error
            
            inc cl
            add bl,02
            jmp again
        break:
        mov root,cl
        
        mov al,cl
        aam
        add ax, 3030h
        
        mov dl,ah
        mov dh,al
        mov ah,02h
        int 21h
        mov dl,dh
        int 21h
        mov ah,4ch
        int 21h
        .exit
        
        error:
            lea dx,message
            mov ah,09h
            int 21h
            
            mov ah,4ch
            int 21h
        .exit
    main endp
end main
        
        